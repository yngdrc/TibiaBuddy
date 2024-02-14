package com.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("character")
    val characterData: CharacterData
)