package app.aventurine.tibiabuddy.api.tibiaData.worlds

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class WorldResponse(
    @SerializedName("world")
    val world: World,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)