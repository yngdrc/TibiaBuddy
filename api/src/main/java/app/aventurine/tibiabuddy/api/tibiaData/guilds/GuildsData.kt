package app.aventurine.tibiabuddy.api.tibiaData.guilds

import com.google.gson.annotations.SerializedName

data class GuildsData(
    @SerializedName("active")
    val active: List<SimpleGuild>,

    @SerializedName("formation")
    val formation: List<SimpleGuild>,

    @SerializedName("world")
    val world: String
)