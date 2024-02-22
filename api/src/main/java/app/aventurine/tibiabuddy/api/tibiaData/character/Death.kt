package app.aventurine.tibiabuddy.api.tibiaData.character

import com.google.gson.annotations.SerializedName

data class Death(
    @SerializedName("assists")
    val assists: List<ResponsibleForDeath>,

    @SerializedName("killers")
    val killers: List<ResponsibleForDeath>,

    @SerializedName("level")
    val level: Int,

    @SerializedName("reason")
    val reason: String,

    @SerializedName("time")
    val time: String
)