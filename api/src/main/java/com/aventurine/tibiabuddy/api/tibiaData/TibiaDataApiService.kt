package com.aventurine.tibiabuddy.api.tibiaData

import com.aventurine.tibiabuddy.api.ApiSetup
import com.aventurine.tibiabuddy.api.tibiaData.models.BoostableBossesResponse
import com.aventurine.tibiabuddy.api.tibiaData.models.CharacterResponse
import com.aventurine.tibiabuddy.api.tibiaData.models.WorldsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TibiaDataApiService {
    @GET("${ApiSetup.TIBIA_BUDDY_API_VERSION}/boostablebosses")
    suspend fun getBoostableBosses(): BoostableBossesResponse

    @GET("${ApiSetup.TIBIA_BUDDY_API_VERSION}/character/{name}")
    suspend fun getCharacter(
        @Path("name") name: String
    ): CharacterResponse

    @GET("${ApiSetup.TIBIA_BUDDY_API_VERSION}/worlds")
    suspend fun getWorlds(): WorldsResponse
}