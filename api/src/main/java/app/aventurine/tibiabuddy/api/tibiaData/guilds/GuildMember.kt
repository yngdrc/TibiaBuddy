package app.aventurine.tibiabuddy.api.tibiaData.guilds

import com.google.gson.annotations.SerializedName

data class GuildMember(
    @SerializedName("joined")
    val joined: String,

    @SerializedName("level")
    val level: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("rank")
    val rank: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("vocation")
    val vocation: String
)