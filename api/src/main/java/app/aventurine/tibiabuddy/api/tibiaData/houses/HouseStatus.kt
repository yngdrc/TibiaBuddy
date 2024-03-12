package app.aventurine.tibiabuddy.api.tibiaData.houses

import com.google.gson.annotations.SerializedName

data class HouseStatus(
    @SerializedName("auction")
    val auction: HouseAuction,

    @SerializedName("is_auctioned")
    val isAuctioned: Boolean,

    @SerializedName("is_moving")
    val isMoving: Boolean,

    @SerializedName("is_rented")
    val isRented: Boolean,

    @SerializedName("is_transfering")
    val isTransferring: Boolean,

    @SerializedName("original")
    val original: String,

    @SerializedName("rental")
    val rental: HouseRental
)