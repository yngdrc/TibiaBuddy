package app.aventurine.tibiabuddy.api.tibiaData.houses

import com.google.gson.annotations.SerializedName

data class House(
    @SerializedName("houseid")
    val houseId: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("paid")
    val paid: String? = null,

    @SerializedName("town")
    val town: String? = null,

    @SerializedName("beds")
    val beds: Int? = null,

    @SerializedName("img")
    val img: String? = null,

    @SerializedName("rent")
    val rent: Int? = null,

    @SerializedName("size")
    val size: Int? = null,

    @SerializedName("status")
    val status: HouseStatus? = null,

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("world")
    val world: String? = null,

    @SerializedName("auction")
    val auction: HouseAuction? = null,

    @SerializedName("rented")
    val rented: Boolean? = null
)