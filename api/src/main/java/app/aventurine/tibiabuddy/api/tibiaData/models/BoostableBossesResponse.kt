package app.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class BoostableBossesResponse(
    @SerializedName("boostable_boss_list")
    val boostableBosses: List<BoostableBoss>,

    @SerializedName("boosted")
    val boosted: BoostableBoss,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)