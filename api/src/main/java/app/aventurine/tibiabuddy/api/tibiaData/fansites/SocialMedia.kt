package app.aventurine.tibiabuddy.api.tibiaData.fansites

import com.google.gson.annotations.SerializedName

data class SocialMedia(
    @SerializedName("discord")
    val discord: Boolean,

    @SerializedName("facebook")
    val facebook: String,

    @SerializedName("instagram")
    val instagram: Boolean,

    @SerializedName("reddit")
    val reddit: Boolean,

    @SerializedName("twitch")
    val twitch: Boolean,

    @SerializedName("twitter")
    val twitter: Boolean,

    @SerializedName("youtube")
    val youtube: Boolean
)