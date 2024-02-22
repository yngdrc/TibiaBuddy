package app.aventurine.tibiabuddy.map

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import ovh.plrapps.mapcompose.api.addCallout
import ovh.plrapps.mapcompose.api.addLayer
import ovh.plrapps.mapcompose.api.addMarker
import ovh.plrapps.mapcompose.api.onMarkerClick
import ovh.plrapps.mapcompose.api.reloadTiles
import ovh.plrapps.mapcompose.api.removeAllMarkers
import ovh.plrapps.mapcompose.api.removeCallout
import ovh.plrapps.mapcompose.api.scale
import ovh.plrapps.mapcompose.core.TileStreamProvider
import ovh.plrapps.mapcompose.ui.layout.Fill
import ovh.plrapps.mapcompose.ui.state.MapState
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    @ApplicationContext private val applicationContext: Context
) : ViewModel() {

    private val availableLevels = 0..15
    val currentLevel = mutableIntStateOf(7)

    private val visibleCallOutId = mutableStateOf("")
    private val tileStreamProvider = TileStreamProvider { row, col, _ ->
        try {
            val x = (col * 256) + 31744
            val y = (row * 256) + 30976
            applicationContext.assets?.open(
                "minimap/Minimap_Color_${x}_${y}_${currentLevel.intValue}.png"
            )
        } catch (e: Exception) {
            null
        }
    }

    fun changeLevel(newLevel: Int) {
        if (newLevel !in availableLevels)
            return

        mapState.removeCallout(id = visibleCallOutId.value)
        mapState.removeAllMarkers()
        mapState.reloadTiles()

        markersState.filter { marker ->
            marker.floorId == newLevel
        }.forEach { marker ->
            mapState.addMarker(
                id = marker.id,
                x = ((marker.x - 31744) / 2560) + 0.0002,
                y = ((marker.y - 30976) / 2048) + 0.0008
            ) {
                Image(
                    painter = painterResource(id = marker.iconRes),
                    contentDescription = "",
                    modifier = Modifier.size(Dp(mapState.scale))
                )
            }
        }

        currentLevel.intValue = newLevel
    }

    private val markersState by mutableStateOf(
        MarkerUtils.readMarkersData(appContext = applicationContext)
    )

    val mapState: MapState by mutableStateOf(
        MapState(levelCount = 1, fullWidth = 2560, fullHeight = 2048, tileSize = 256) {
            minimumScaleMode(minimumScaleMode = Fill)
            maxScale(10.0f)
            bitmapFilteringEnabled(false)
        }.apply {
            addLayer(tileStreamProvider = tileStreamProvider)

            markersState.filter { marker ->
                marker.floorId == currentLevel.intValue
            }.forEach { marker ->
                addMarker(
                    id = marker.id,
                    x = ((marker.x - 31744) / 2560) + 0.0002,
                    y = ((marker.y - 30976) / 2048) + 0.0008
                ) {
                    Image(
                        painter = painterResource(id = marker.iconRes),
                        contentDescription = "",
                        modifier = Modifier.size(Dp(scale))
                    )
                }
            }

            onMarkerClick { id, x, y ->
                addCallout(
                    id = id,
                    x = x,
                    y = y - 0.0018
                ) {
                    if (scale < 6.5)
                        return@addCallout

                    val markerDescription = markersState.first { it.id == id }.markerDescription
                    if (markerDescription.isEmpty())
                        return@addCallout

                    MarkerCallOut(
                        text = markerDescription,
                        currentZoom = scale
                    )

                    visibleCallOutId.value = id
                }
            }
        }
    )
}