package com.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class BoostableBossesResponse(
    @SerializedName("boosted")
    val boosted: BoostableBoss,

    @SerializedName("boostable_boss_list")
    val boostableBosses: List<BoostableBoss>
)