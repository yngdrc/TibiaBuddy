package app.aventurine.tibiabuddy.api.tibiaData.creatures

import com.google.gson.annotations.SerializedName

data class CreaturesData(
    @SerializedName("boosted")
    val boosted: SimpleCreature,

    @SerializedName("creature_list")
    val creatureList: List<SimpleCreature>
)