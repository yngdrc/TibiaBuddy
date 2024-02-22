package app.aventurine.tibiabuddy.api.tibiaData.houses

import com.google.gson.annotations.SerializedName

data class HousesData(
    @SerializedName("guildhall_list")
    val guildHallList: List<House>,

    @SerializedName("house_list")
    val houseList: List<House>,

    @SerializedName("town")
    val town: String,

    @SerializedName("world")
    val world: String
)