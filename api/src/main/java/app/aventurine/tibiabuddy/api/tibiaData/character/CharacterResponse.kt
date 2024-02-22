package app.aventurine.tibiabuddy.api.tibiaData.character

import app.aventurine.tibiabuddy.api.tibiaData.common.ResponseInformation
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("character")
    val characterData: CharacterData,

    @SerializedName("information")
    val responseInformation: ResponseInformation
)