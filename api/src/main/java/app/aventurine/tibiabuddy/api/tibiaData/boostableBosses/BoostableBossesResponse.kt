package app.aventurine.tibiabuddy.api.tibiaData.boostableBosses

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class BoostableBossesResponse(
    @SerializedName("boostable_boss_list")
    val boostableBosses: List<BoostableBoss>,

    @SerializedName("boosted")
    val boosted: BoostableBoss,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)