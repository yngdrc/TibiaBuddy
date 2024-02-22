package app.aventurine.tibiabuddy.api.tibiaData.killStatistics

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class KillStatisticsResponse(
    @SerializedName("killstatistics")
    val killStatistics: KillStatisticsData,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)