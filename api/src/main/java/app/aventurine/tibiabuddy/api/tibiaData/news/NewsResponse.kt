package app.aventurine.tibiabuddy.api.tibiaData.news

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("news")
    val news: List<News>,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)