package app.aventurine.tibiabuddy.api.tibiaData.creatures

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class CreatureResponse(
    @SerializedName("creature")
    val creature: Creature,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)