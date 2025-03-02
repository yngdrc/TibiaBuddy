package app.aventurine.tibiabuddy.ui.map

import androidx.lifecycle.ViewModel
import app.aventurine.tibiabuddy.data.ApiConfig
import app.aventurine.tibiabuddy.data.fileStorage.FileStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import ovh.plrapps.mapcompose.api.addLayer
import ovh.plrapps.mapcompose.api.reloadTiles
import ovh.plrapps.mapcompose.core.TileStreamProvider
import ovh.plrapps.mapcompose.ui.layout.Fill
import ovh.plrapps.mapcompose.ui.state.MapState
import java.io.InputStream
import java.net.URL
import javax.inject.Inject

data class MapUiState(
    val floorId: Int
)

@HiltViewModel
class MapViewModel @Inject constructor(
    private val fileStorage: FileStorage
) : ViewModel() {
    companion object {
        const val TILE_SIZE: Int = 256
        const val LEFT_MOST_TILE: Int = 31744
        const val RIGHT_MOST_TILE: Int = 34048
        const val TOP_MOST_TILE: Int = 30976
        const val BOTTOM_MOST_TILE: Int = 32768

        const val MAP_WIDTH = RIGHT_MOST_TILE - LEFT_MOST_TILE + TILE_SIZE
        const val MAP_HEIGHT = BOTTOM_MOST_TILE - TOP_MOST_TILE + TILE_SIZE
    }

    private val _mapUiState: MutableStateFlow<MapUiState> = MutableStateFlow(
        MapUiState(floorId = 7)
    )

    val mapUiState: StateFlow<MapUiState> = _mapUiState.asStateFlow()

    inner class TileProvider : TileStreamProvider {
        private val minimapColorPrefix: String = "Minimap_Color"
        private val minimapPath: String = "/minimap"

        private fun getTileFileName(
            x: Int,
            y: Int,
            floorId: Int
        ): String = "${minimapColorPrefix}_${x}_${y}_${floorId}.png"

        private fun getTileUrl(
            tileFileName: String
        ): String = "${ApiConfig.TIBIA_BUDDY_HOSTNAME}$minimapPath/$tileFileName"

        override suspend fun getTileStream(
            row: Int,
            col: Int,
            zoomLvl: Int
        ): InputStream? = try {
            val tileFileName = getTileFileName(
                x = getX(col = col),
                y = getY(row = row),
                floorId = mapUiState.value.floorId
            )

            withContext(Dispatchers.IO) {
                val localFile = fileStorage.getFileIfExists(fileName = tileFileName).getOrNull()
                if (localFile != null)
                    return@withContext localFile.inputStream()

                val tileUrl = getTileUrl(tileFileName = tileFileName)
                val inputStream = URL(tileUrl).openStream()
                this.async {
                    fileStorage.saveFile(tileFileName, inputStream.readBytes())
                }.await().getOrThrow().inputStream()
            }
        } catch (e: Exception) {
            null
        }

        private fun getX(col: Int): Int = (col * TILE_SIZE) + LEFT_MOST_TILE
        private fun getY(row: Int): Int = (row * TILE_SIZE) + TOP_MOST_TILE
    }

    fun setFloorId(floorId: Int) {
        val availableFloorIds = 0..15
        if (floorId !in availableFloorIds)
            return

        _mapUiState.update { state ->
            state.copy(floorId = floorId)
        }

        mapState.reloadTiles()
    }

    val mapState: MapState = MapState(
        levelCount = 1,
        fullWidth = MAP_WIDTH,
        fullHeight = MAP_HEIGHT,
        tileSize = TILE_SIZE
    ) {
        minimumScaleMode(minimumScaleMode = Fill)
        maxScale(10.0f)
        bitmapFilteringEnabled(false)
    }.apply {
        addLayer(tileStreamProvider = TileProvider())
    }
}