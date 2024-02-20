package app.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class AccountBadge(
    @SerializedName("description")
    val description: String,

    @SerializedName("icon_url")
    val iconUrl: String,

    @SerializedName("name")
    val name: String
)