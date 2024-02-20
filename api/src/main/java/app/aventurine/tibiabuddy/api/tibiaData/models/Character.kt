package app.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("account_status")
    val accountStatus: String,

    @SerializedName("achievement_points")
    val achievementPoints: Int,

    @SerializedName("comment")
    val comment: String,

    @SerializedName("deletion_date")
    val deletionDate: String,

    @SerializedName("former_names")
    val formerNames: List<String>,

    @SerializedName("former_worlds")
    val formerWorlds: List<String>,

    @SerializedName("guild")
    val guild: Guild,

    @SerializedName("houses")
    val houses: List<House>,

    @SerializedName("last_login")
    val lastLogin: String,

    @SerializedName("level")
    val level: Int,

    @SerializedName("married_to")
    val marriedTo: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("position")
    val position: String,

    @SerializedName("residence")
    val residence: String,

    @SerializedName("sex")
    val sex: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("traded")
    val traded: Boolean,

    @SerializedName("unlocked_titles")
    val unlockedTitles: Int,

    @SerializedName("vocation")
    val vocation: String,

    @SerializedName("world")
    val world: String
)