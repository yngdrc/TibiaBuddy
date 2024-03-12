package app.aventurine.tibiabuddy.api.tibiaData.creatures

import com.google.gson.annotations.SerializedName

data class SimpleCreature(
    @SerializedName("featured")
    val featured: Boolean,

    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("race")
    val race: String
)