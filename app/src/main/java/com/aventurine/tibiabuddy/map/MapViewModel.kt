package com.aventurine.tibiabuddy.map

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.AndroidViewModel
import com.aventurine.tibiabuddy.common.MarkerCallOut
import ovh.plrapps.mapcompose.api.addCallout
import ovh.plrapps.mapcompose.api.addLayer
import ovh.plrapps.mapcompose.api.addMarker
import ovh.plrapps.mapcompose.api.onMarkerClick
import ovh.plrapps.mapcompose.api.removeAllLayers
import ovh.plrapps.mapcompose.api.removeAllMarkers
import ovh.plrapps.mapcompose.api.scale
import ovh.plrapps.mapcompose.ui.layout.Fill
import ovh.plrapps.mapcompose.ui.state.MapState

class MapViewModel(
    private val application: Application
) : AndroidViewModel(application) {
    val level = mutableIntStateOf(7)

    fun changeLevel(newLevel: Int) {
        if (newLevel !in 0..15)
            return

        level.intValue = newLevel
        mapState.removeAllLayers()
        mapState.removeAllMarkers()
        mapState.addLayer(
            makeTileStreamProvider(
                appContext = application.applicationContext,
                level = newLevel
            )
        )

        markersState.filter { marker ->
            marker.floorId == level.intValue
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
    }

    val markersState by mutableStateOf(
        MarkerUtils.readMarkersData(appContext = application.applicationContext)
    )

    val mapState: MapState by mutableStateOf(
        MapState(levelCount = 1, fullWidth = 2560, fullHeight = 2048, tileSize = 256) {
            minimumScaleMode(minimumScaleMode = Fill)
            maxScale(10.0f)
            bitmapFilteringEnabled(false)
        }.apply {
            addLayer(
                makeTileStreamProvider(
                    appContext = application.applicationContext,
                    level = level.intValue
                )
            )

            markersState.filter { marker ->
                marker.floorId == level.intValue
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
                }
            }
        }
    )
}