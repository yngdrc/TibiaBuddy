package app.aventurine.tibiabuddy.api.tibiaData.houses

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class HouseResponse(
    @SerializedName("house")
    val house: House,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)