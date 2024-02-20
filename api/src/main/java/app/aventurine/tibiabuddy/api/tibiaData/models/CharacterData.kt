package app.aventurine.tibiabuddy.api.tibiaData.models

import com.google.gson.annotations.SerializedName

data class CharacterData(
    @SerializedName("account_badges")
    val accountBadges: List<AccountBadge>,

    @SerializedName("account_information")
    val accountInformation: AccountInformation,

    @SerializedName("achievements")
    val achievements: List<Achievement>,

    @SerializedName("character")
    val character: Character,

    @SerializedName("deaths")
    val deaths: List<Death>,

    @SerializedName("deaths_truncated")
    val deathsTruncated: Boolean,

    @SerializedName("other_characters")
    val otherCharacters: List<OtherCharacter>
)