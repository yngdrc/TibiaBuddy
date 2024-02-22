package app.aventurine.tibiabuddy.api.tibiaData.houses

import com.google.gson.annotations.SerializedName

data class HouseAuction(
    @SerializedName("auction_end")
    val auctionEnd: String? = null,

    @SerializedName("auction_ongoing")
    val auctionOngoing: Boolean? = null,

    @SerializedName("current_bid")
    val currentBid: Int,

    @SerializedName("current_bidder")
    val currentBidder: String? = null,

    @SerializedName("finished")
    val finished: Boolean? = null,

    @SerializedName("time_left")
    val timeLeft: String? = null
)