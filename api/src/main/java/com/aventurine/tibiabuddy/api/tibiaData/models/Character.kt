package com.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("account_status")
    val accountStatus: String,

    @SerializedName("achievement_points")
    val achievementPoints: Int,

    @SerializedName("last_login")
    val lastLogin: String,

    @SerializedName("level")
    val level: Int,

    @SerializedName("residence")
    val residence: String,

    @SerializedName("sex")
    val sex: String,

    @SerializedName("vocation")
    val vocation: String,

    @SerializedName("world")
    val world: String,

    @SerializedName("name")
    val name: String
)