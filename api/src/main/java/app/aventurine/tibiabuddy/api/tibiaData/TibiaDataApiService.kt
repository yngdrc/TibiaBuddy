package app.aventurine.tibiabuddy.api.tibiaData

import app.aventurine.tibiabuddy.api.ApiConfig
import app.aventurine.tibiabuddy.api.tibiaData.models.BoostableBossesResponse
import app.aventurine.tibiabuddy.api.tibiaData.models.CharacterResponse
import app.aventurine.tibiabuddy.api.tibiaData.models.CreatureResponse
import app.aventurine.tibiabuddy.api.tibiaData.models.WorldsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TibiaDataApiService {
    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/boostablebosses")
    suspend fun getBoostableBosses(): BoostableBossesResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/character/{name}")
    suspend fun getCharacter(
        @Path("name") name: String
    ): CharacterResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/creature/{race}")
    suspend fun getCreature(
        @Path("race") race: String
    ): CreatureResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/worlds")
    suspend fun getWorlds(): WorldsResponse
}