package app.aventurine.tibiabuddy.api.tibiaData.news

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("category")
    val category: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("news")
    val news: String? = null,

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("url")
    val url: String,

    @SerializedName("url_api")
    val urlApi: String? = null,

    @SerializedName("content")
    val content: String? = null,

    @SerializedName("content_html")
    val contentHtml: String? = null,

    @SerializedName("title")
    val title: String? = null
)