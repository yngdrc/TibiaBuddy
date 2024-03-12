package app.aventurine.tibiabuddy.api.tibiaData.spells

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class SpellResponse(
    @SerializedName("spell")
    val spell: Spell,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)