package app.aventurine.tibiabuddy.api.tibiaData.creatures

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class CreaturesResponse(
    @SerializedName("creatures")
    val creatures: List<CreaturesData>,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)