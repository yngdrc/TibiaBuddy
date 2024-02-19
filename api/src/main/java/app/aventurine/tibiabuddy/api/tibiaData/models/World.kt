package app.aventurine.tibiabuddy.api.tibiaData.models

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
    val transferType: String
)