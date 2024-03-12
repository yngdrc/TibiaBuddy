package app.aventurine.tibiabuddy.api.tibiaData.guilds

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class GuildResponse(
    @SerializedName("guild")
    val guild: Guild,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)