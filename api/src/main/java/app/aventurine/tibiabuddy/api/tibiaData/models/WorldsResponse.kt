package app.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class WorldsResponse(
    @SerializedName("worlds")
    val worldsData: WorldsData
)