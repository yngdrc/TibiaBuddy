package app.aventurine.tibiabuddy.api.tibiaData.character

import com.google.gson.annotations.SerializedName

data class Achievement(
    @SerializedName("grade")
    val grade: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("secret")
    val secret: Boolean
)