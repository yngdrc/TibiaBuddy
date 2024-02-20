package app.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class Guild(
    @SerializedName("name")
    val name: String,

    @SerializedName("rank")
    val rank: String
)