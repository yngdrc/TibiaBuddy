package app.aventurine.tibiabuddy.api.tibiaData.fansites

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class FanSitesResponse(
    @SerializedName("fansites")
    val fanSites: FanSitesData,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)