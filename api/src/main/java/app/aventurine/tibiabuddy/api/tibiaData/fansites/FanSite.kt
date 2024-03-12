package app.aventurine.tibiabuddy.api.tibiaData.fansites

import com.google.gson.annotations.SerializedName

data class FanSite(
    @SerializedName("contact")
    val contact: String,

    @SerializedName("content_type")
    val contentType: ContentType,

    @SerializedName("fansite_item")
    val fanSiteItem: Boolean,

    @SerializedName("fansite_item_url")
    val fanSiteItemUrl: String,

    @SerializedName("homepage")
    val homepage: String,

    @SerializedName("languages")
    val languages: List<String>,

    @SerializedName("logo_url")
    val logoUrl: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("social_media")
    val socialMedia: SocialMedia,

    @SerializedName("specials")
    val specials: List<String>
)