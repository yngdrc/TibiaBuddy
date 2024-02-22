package app.aventurine.tibiabuddy.api.tibiaData.killStatistics

import com.google.gson.annotations.SerializedName

data class KillStatisticsData(
    @SerializedName("entries")
    val entries: List<KillStatistic>,

    @SerializedName("total")
    val total: List<KillStatistic>,

    @SerializedName("world")
    val world: String
)