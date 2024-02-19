package app.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class BoostableBoss(
    @SerializedName("name")
    val name: String,

    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("featured")
    val featured: Boolean
)