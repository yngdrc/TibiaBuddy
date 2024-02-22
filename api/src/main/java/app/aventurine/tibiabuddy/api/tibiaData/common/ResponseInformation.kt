package app.aventurine.tibiabuddy.api.tibiaData.common

import com.google.gson.annotations.SerializedName

data class ResponseInformation(
    @SerializedName("api")
    val apiDetails: ApiDetails,

    @SerializedName("status")
    val status: Status,

    @SerializedName("timestamp")
    val timestamp: String
)