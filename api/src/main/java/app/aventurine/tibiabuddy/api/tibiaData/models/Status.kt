package app.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("error")
    val error: Int,

    @SerializedName("http_code")
    val httpCode: Int,

    @SerializedName("message")
    val message: String
)