package app.aventurine.tibiabuddy.api.tibiaData.common

import com.google.gson.annotations.SerializedName

data class ApiDetails(
    @SerializedName("commit")
    val commit: String,

    @SerializedName("release")
    val release: String,

    @SerializedName("version")
    val version: Int
)