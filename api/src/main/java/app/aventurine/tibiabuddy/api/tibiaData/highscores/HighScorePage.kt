package app.aventurine.tibiabuddy.api.tibiaData.highscores

import com.google.gson.annotations.SerializedName

data class HighScorePage(
    @SerializedName("current_page")
    val currentPage: Int,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_records")
    val totalRecords: Int
)