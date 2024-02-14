package com.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class CharacterData(
    @SerializedName("character")
    val character: Character
)