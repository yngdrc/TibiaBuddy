package app.aventurine.tibiabuddy.api.tibiaData.spells

import com.google.gson.annotations.SerializedName

data class RuneInformation(
    @SerializedName("damage_type")
    val damageType: String,

    @SerializedName("group_attack")
    val groupAttack: Boolean,

    @SerializedName("group_healing")
    val groupHealing: Boolean,

    @SerializedName("group_support")
    val groupSupport: Boolean,

    @SerializedName("level")
    val level: Int,

    @SerializedName("magic_level")
    val magicLevel: Int,

    @SerializedName("vocation")
    val vocation: List<String>
)