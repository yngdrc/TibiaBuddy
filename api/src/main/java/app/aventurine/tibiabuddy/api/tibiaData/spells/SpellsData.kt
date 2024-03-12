package app.aventurine.tibiabuddy.api.tibiaData.spells

import com.google.gson.annotations.SerializedName

data class SpellsData(
    @SerializedName("spell_list")
    val spellList: List<Spell>,

    @SerializedName("spells_filter")
    val spellsFilter: String
)