package app.aventurine.tibiabuddy.api.tibiaData.creatures

import com.google.gson.annotations.SerializedName

data class Creature(
    @SerializedName("be_convinced")
    val beConvinced: Boolean,

    @SerializedName("be_paralysed")
    val beParalysed: Boolean,

    @SerializedName("be_summoned")
    val beSummoned: Boolean,

    @SerializedName("behaviour")
    val behaviour: String,

    @SerializedName("convinced_mana")
    val convincedMana: Int,

    @SerializedName("description")
    val description: String,

    @SerializedName("experience_points")
    val experiencePoints: Int,

    @SerializedName("featured")
    val featured: Boolean,

    @SerializedName("healed")
    val healed: List<String>,

    @SerializedName("hitpoints")
    val hitpoints: Int,

    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("immune")
    val immune: List<String>,

    @SerializedName("is_lootable")
    val isLootable: Boolean,

    @SerializedName("loot_list")
    val lootList: List<String>,

    @SerializedName("name")
    val name: String,

    @SerializedName("race")
    val race: String,

    @SerializedName("see_invisible")
    val seeInvisible: Boolean,

    @SerializedName("strong")
    val strong: List<String>,

    @SerializedName("summoned_mana")
    val summonedMana: Int,

    @SerializedName("weakness")
    val weakness: List<String>
)