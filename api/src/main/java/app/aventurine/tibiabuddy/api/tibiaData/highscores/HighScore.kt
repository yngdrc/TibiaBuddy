package app.aventurine.tibiabuddy.api.tibiaData.highscores

import com.google.gson.annotations.SerializedName

data class HighScore(
    @SerializedName("level")
    val level: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("rank")
    val rank: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("value")
    val value: Int,

    @SerializedName("vocation")
    val vocation: String,

    @SerializedName("world")
    val world: String
)