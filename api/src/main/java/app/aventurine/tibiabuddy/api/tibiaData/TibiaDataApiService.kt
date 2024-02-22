package app.aventurine.tibiabuddy.api.tibiaData

import app.aventurine.tibiabuddy.api.ApiConfig
import app.aventurine.tibiabuddy.api.tibiaData.boostableBosses.BoostableBossesResponse
import app.aventurine.tibiabuddy.api.tibiaData.character.CharacterResponse
import app.aventurine.tibiabuddy.api.tibiaData.creatures.CreatureResponse
import app.aventurine.tibiabuddy.api.tibiaData.creatures.CreaturesResponse
import app.aventurine.tibiabuddy.api.tibiaData.fansites.FanSitesResponse
import app.aventurine.tibiabuddy.api.tibiaData.guilds.GuildResponse
import app.aventurine.tibiabuddy.api.tibiaData.guilds.GuildsResponse
import app.aventurine.tibiabuddy.api.tibiaData.highscores.HighScoresResponse
import app.aventurine.tibiabuddy.api.tibiaData.houses.HouseResponse
import app.aventurine.tibiabuddy.api.tibiaData.houses.HousesResponse
import app.aventurine.tibiabuddy.api.tibiaData.killStatistics.KillStatisticsResponse
import app.aventurine.tibiabuddy.api.tibiaData.news.NewsResponse
import app.aventurine.tibiabuddy.api.tibiaData.news.SingleNewsResponse
import app.aventurine.tibiabuddy.api.tibiaData.spells.SpellResponse
import app.aventurine.tibiabuddy.api.tibiaData.spells.SpellsResponse
import app.aventurine.tibiabuddy.api.tibiaData.worlds.WorldResponse
import app.aventurine.tibiabuddy.api.tibiaData.worlds.WorldsResponse
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

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/creatures")
    suspend fun getCreatures(): CreaturesResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/fansites")
    suspend fun getFanSites(): FanSitesResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/guild/{name}")
    suspend fun getGuild(
        @Path("name") name: String
    ): GuildResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/guilds/{world}")
    suspend fun getGuilds(
        @Path("world") world: String
    ): GuildsResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/highscores/{world}/{category}/{vocation}/{page}")
    suspend fun getHighScores(
        @Path("world") world: String,
        @Path("category") category: String,
        @Path("vocation") vocation: String,
        @Path("page") page: Int
    ): HighScoresResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/house/{world}/{house_id}")
    suspend fun getHouse(
        @Path("world") world: String,
        @Path("house_id") houseId: String,
    ): HouseResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/houses/{world}/{town}")
    suspend fun getHouses(
        @Path("world") world: String,
        @Path("town") town: String,
    ): HousesResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/killstatistics/{world}")
    suspend fun getKillStatistics(
        @Path("world") world: String
    ): KillStatisticsResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/news/archive")
    suspend fun getArchivedNews(): NewsResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/news/archive/{days}")
    suspend fun getArchivedNews(
        @Path("days") days: Int = 90
    ): NewsResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/news/id/{news_id}")
    suspend fun getNewsById(
        @Path("news_id") newsId: Int
    ): SingleNewsResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/news/latest")
    suspend fun getLatestNews(): NewsResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/news/newsticker")
    suspend fun getTickerNews(): NewsResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/spell/{spell_id}")
    suspend fun getSpell(
        @Path("spell_id") spellId: Int
    ): SpellResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/spells")
    suspend fun getSpells(): SpellsResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/world/{name}")
    suspend fun getWorld(
        @Path("name") name: String
    ): WorldResponse

    @GET("${ApiConfig.TIBIA_BUDDY_API_VERSION}/worlds")
    suspend fun getWorlds(): WorldsResponse
}