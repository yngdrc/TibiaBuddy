package app.aventurine.tibiabuddy.api.tibiaData.houses

import com.google.gson.annotations.SerializedName

data class HouseRental(
    @SerializedName("moving_date")
    val movingDate: String,

    @SerializedName("owner")
    val owner: String,

    @SerializedName("owner_sex")
    val ownerSex: String,

    @SerializedName("paid_until")
    val paidUntil: String,

    @SerializedName("transfer_accept")
    val transferAccept: Boolean,

    @SerializedName("transfer_price")
    val transferPrice: Int,

    @SerializedName("transfer_receiver")
    val transferReceiver: String
)