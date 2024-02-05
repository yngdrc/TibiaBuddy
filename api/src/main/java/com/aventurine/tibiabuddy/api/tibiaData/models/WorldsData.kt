package com.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class WorldsData(
    @SerializedName("players_online")
    val playersOnline: Int,

    @SerializedName("record_players")
    val recordPlayers: Int,

    @SerializedName("record_date")
    val recordDate: String,

    @SerializedName("regular_worlds")
    val regularWorlds: List<World>,

    @SerializedName("tournament_worlds")
    val tournamentWorlds: List<World>?
)