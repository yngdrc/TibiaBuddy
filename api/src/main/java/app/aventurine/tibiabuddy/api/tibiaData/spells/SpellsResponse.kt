package app.aventurine.tibiabuddy.api.tibiaData.spells

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class SpellsResponse(
    @SerializedName("spells")
    val spells: SpellsData,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)