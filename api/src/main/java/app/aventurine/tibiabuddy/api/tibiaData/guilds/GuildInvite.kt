package app.aventurine.tibiabuddy.api.tibiaData.guilds

import com.google.gson.annotations.SerializedName

data class GuildInvite(
    @SerializedName("date")
    val date: String,

    @SerializedName("name")
    val name: String
)