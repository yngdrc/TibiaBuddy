package app.aventurine.tibiabuddy.api.tibiaData.guilds

import com.google.gson.annotations.SerializedName

data class SimpleGuild(
    @SerializedName("name")
    val name: String,

    @SerializedName("rank")
    val rank: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("logo_url")
    val logoUrl: String? = null
)