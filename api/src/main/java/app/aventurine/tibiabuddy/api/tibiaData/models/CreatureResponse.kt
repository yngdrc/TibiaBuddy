package app.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class CreatureResponse(
    @SerializedName("creature")
    val creature: Creature,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)