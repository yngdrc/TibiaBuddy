package app.aventurine.tibiabuddy.api.tibiaData.killStatistics

import com.google.gson.annotations.SerializedName

data class KillStatistic(
    @SerializedName("last_day_killed")
    val lastDayKilled: Int,

    @SerializedName("last_day_players_killed")
    val lastDayPlayersKilled: Int,

    @SerializedName("last_week_killed")
    val lastWeekKilled: Int,

    @SerializedName("last_week_players_killed")
    val lastWeekPlayersKilled: Int,

    @SerializedName("race")
    val race: String? = null
)