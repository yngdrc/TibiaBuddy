package app.aventurine.tibiabuddy.api.tibiaData.spells

import com.google.gson.annotations.SerializedName

data class SpellInformation(
    @SerializedName("amount")
    val amount: Int,

    @SerializedName("city")
    val city: List<String>,

    @SerializedName("cooldown_alone")
    val coolDownAlone: Int,

    @SerializedName("cooldown_group")
    val coolDownGroup: Int,

    @SerializedName("damage_type")
    val damageType: String,

    @SerializedName("formula")
    val formula: String,

    @SerializedName("group_attack")
    val groupAttack: Boolean,

    @SerializedName("group_healing")
    val groupHealing: Boolean,

    @SerializedName("group_support")
    val groupSupport: Boolean,

    @SerializedName("level")
    val level: Int,

    @SerializedName("mana")
    val mana: Int,

    @SerializedName("premium_only")
    val premiumOnly: Boolean,

    @SerializedName("price")
    val price: Int,

    @SerializedName("soul_points")
    val soulPoints: Int,

    @SerializedName("type_instant")
    val typeInstant: Boolean,

    @SerializedName("type_rune")
    val typeRune: Boolean,

    @SerializedName("vocation")
    val vocation: List<String>
)