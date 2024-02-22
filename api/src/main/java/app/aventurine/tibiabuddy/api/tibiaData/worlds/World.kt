package app.aventurine.tibiabuddy.api.tibiaData.worlds

import app.aventurine.tibiabuddy.api.tibiaData.character.Character
import com.google.gson.annotations.SerializedName

data class World(
    @SerializedName("battleye_date")
    val battleEyeDate: String,

    @SerializedName("battleye_protected")
    val battleEyeProtected: Boolean,

    @SerializedName("game_world_type")
    val gameWorldType: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("players_online")
    val playersOnline: Int,

    @SerializedName("premium_only")
    val premiumOnly: Boolean,

    @SerializedName("pvp_type")
    val pvpType: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("tournament_world_type")
    val tournamentWorldType: String,

    @SerializedName("transfer_type")
    val transferType: String,

    @SerializedName("creation_date")
    val creationDate: String? = null,

    @SerializedName("online_players")
    val onlinePlayers: List<Character>? = null,

    @SerializedName("record_date")
    val recordDate: String? = null,

    @SerializedName("recordPlayers")
    val recordPlayers: Int? = null,

    @SerializedName("world_quest_titles")
    val worldQuestTitles: List<String>? = null
)