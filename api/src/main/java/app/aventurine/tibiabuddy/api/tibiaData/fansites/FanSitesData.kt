package app.aventurine.tibiabuddy.api.tibiaData.fansites

import com.google.gson.annotations.SerializedName

data class FanSitesData(
    @SerializedName("promoted")
    val promotedFanSites: List<FanSite>,

    @SerializedName("supported")
    val supportedFanSites: List<FanSite>
)