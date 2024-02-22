package app.aventurine.tibiabuddy.api.tibiaData.highscores

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class HighScoresResponse(
    @SerializedName("highscores")
    val highscores: HighScoresData,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)