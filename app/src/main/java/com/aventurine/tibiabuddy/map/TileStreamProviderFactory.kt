package com.aventurine.cheminsight.android

import android.content.Context
import ovh.plrapps.mapcompose.core.TileStreamProvider

fun makeTileStreamProvider(
    appContext: Context,
    level: Int
) =
    TileStreamProvider { row, col, _ ->
        try {
            val x = (col * 256) + 31744
            val y = (row * 256) + 30976
            appContext.assets?.open("minimap/Minimap_Color_${x}_${y}_${level}.png")
        } catch (e: Exception) {
            null
        }
    }