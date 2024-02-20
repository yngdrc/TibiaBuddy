package app.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class House(
    @SerializedName("houseid")
    val houseId: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("paid")
    val paid: String,

    @SerializedName("town")
    val town: String
)