package app.aventurine.tibiabuddy.api.tibiaData.fansites

import com.google.gson.annotations.SerializedName

data class ContentType(
    @SerializedName("statistics")
    val statistics: Boolean,

    @SerializedName("texts")
    val texts: Boolean,

    @SerializedName("tools")
    val tools: Boolean,

    @SerializedName("wiki")
    val wiki: Boolean
)