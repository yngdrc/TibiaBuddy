package app.aventurine.tibiabuddy.api.tibiaData.guilds

import app.aventurine.tibiabuddy.api.tibiaData.houses.House
import com.google.gson.annotations.SerializedName

data class Guild(
    @SerializedName("active")
    val active: Boolean,

    @SerializedName("description")
    val description: String,

    @SerializedName("disband_condition")
    val disbandCondition: String,

    @SerializedName("disband_date")
    val disbandDate: String,

    @SerializedName("founded")
    val founded: String,

    @SerializedName("guildhalls")
    val guildHalls: List<House>,

    @SerializedName("homepage")
    val homepage: String,

    @SerializedName("in_war")
    val inWar: Boolean,

    @SerializedName("invites")
    val invites: List<GuildInvite>,

    @SerializedName("logo_url")
    val logoUrl: String,

    @SerializedName("members")
    val members: List<GuildMember>,

    @SerializedName("members_invited")
    val membersInvited: Int,

    @SerializedName("members_total")
    val membersTotal: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("open_applications")
    val openApplications: Boolean,

    @SerializedName("players_offline")
    val playersOffline: Int,

    @SerializedName("players_online")
    val playersOnline: Int,

    @SerializedName("world")
    val world: String
)