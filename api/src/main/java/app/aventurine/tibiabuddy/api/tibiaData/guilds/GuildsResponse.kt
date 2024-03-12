package app.aventurine.tibiabuddy.api.tibiaData.guilds

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class GuildsResponse(
    @SerializedName("guilds")
    val guilds: GuildsData,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)