package app.aventurine.tibiabuddy.api.tibiaData.models

import android.telephony.AccessNetworkConstants.GeranBand
import com.google.gson.annotations.SerializedName

data class ResponsibleForDeath(
    @SerializedName("name")
    val name: String,

    @SerializedName("player")
    val player: Boolean,

    @SerializedName("summon")
    val summon: String,

    @SerializedName("traded")
    val traded: Boolean
)