package app.aventurine.tibiabuddy.api.tibiaData.character

import com.google.gson.annotations.SerializedName

data class AccountInformation(
    @SerializedName("created")
    val created: String,

    @SerializedName("loyalty_title")
    val loyaltyTitle: String,

    @SerializedName("position")
    val position: String
)