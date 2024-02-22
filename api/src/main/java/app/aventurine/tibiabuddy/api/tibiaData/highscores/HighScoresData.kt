package app.aventurine.tibiabuddy.api.tibiaData.highscores

import com.google.gson.annotations.SerializedName

data class HighScoresData(
    @SerializedName("category")
    val category: String,

    @SerializedName("highscore_age")
    val highScoreAge: Int,

    @SerializedName("highscore_list")
    val highScoreList: List<HighScore>,

    @SerializedName("highscore_page")
    val highScorePage: HighScorePage,

    @SerializedName("vocation")
    val vocation: String,

    @SerializedName("world")
    val world: String
)