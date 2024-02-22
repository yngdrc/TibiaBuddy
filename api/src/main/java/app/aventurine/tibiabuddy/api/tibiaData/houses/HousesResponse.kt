package app.aventurine.tibiabuddy.api.tibiaData.houses

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class HousesResponse(
    @SerializedName("houses")
    val houses: HousesData,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)