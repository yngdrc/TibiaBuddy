package app.aventurine.tibiabuddy.api.tibiaData.spells

import com.google.gson.annotations.SerializedName

data class Spell(
    @SerializedName("description")
    val description: String,

    @SerializedName("has_rune_information")
    val hasRuneInformation: Boolean,

    @SerializedName("has_spell_information")
    val hasSpellInformation: Boolean,

    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("rune_information")
    val runeInformation: RuneInformation,

    @SerializedName("spell_id")
    val spellId: String,

    @SerializedName("spell_information")
    val spellInformation: SpellInformation,

    @SerializedName("formula")
    val formula: String? = null,

    @SerializedName("group_attack")
    val groupAttack: Boolean? = null,

    @SerializedName("group_healing")
    val groupHealing: Boolean? = null,

    @SerializedName("group_support")
    val groupSupport: Boolean? = null,

    @SerializedName("level")
    val level: Int? = null,

    @SerializedName("mana")
    val mana: Int? = null,

    @SerializedName("premium_only")
    val premiumOnly: Boolean? = null,

    @SerializedName("price")
    val price: Int? = null,

    @SerializedName("type_instant")
    val typeInstant: Boolean? = null,

    @SerializedName("type_rune")
    val typeRune: Boolean? = null
)