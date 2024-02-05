package com.aventurine.tibiabuddy.api.tibiaData

import com.aventurine.tibiabuddy.api.ApiSetup
import com.aventurine.tibiabuddy.api.tibiaData.models.BoostableBossesData
import com.aventurine.tibiabuddy.api.tibiaData.models.WorldsData
import com.aventurine.tibiabuddy.api.tibiaData.models.WorldsResponse
import retrofit2.http.GET

interface TibiaDataApiService {
    @GET("${ApiSetup.TIBIA_BUDDY_API_VERSION}/boostablebosses")
    suspend fun getBoostableBosses(): BoostableBossesData

    @GET("${ApiSetup.TIBIA_BUDDY_API_VERSION}/worlds")
    suspend fun getWorlds(): WorldsResponse
}