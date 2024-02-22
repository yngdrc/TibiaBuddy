package app.aventurine.tibiabuddy.api.tibiaData.character

import com.google.gson.annotations.SerializedName

data class OtherCharacter(
    @SerializedName("deleted")
    val deleted: Boolean,

    @SerializedName("main")
    val main: Boolean,

    @SerializedName("name")
    val name: String,

    @SerializedName("position")
    val position: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("traded")
    val traded: Boolean,

    @SerializedName("world")
    val world: String
)