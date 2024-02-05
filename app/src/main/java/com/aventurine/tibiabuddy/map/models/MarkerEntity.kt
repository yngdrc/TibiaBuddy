package com.aventurine.tibiabuddy.map.models

import androidx.annotation.DrawableRes

data class MarkerEntity(
    val x: Double,
    val y: Double,
    val floorId: Int,
    @DrawableRes val iconRes: Int,
    val markerDescription: String
) {
    val id: String
        get() = "${x}_${y}_${floorId}"
}