package app.aventurine.tibiabuddy.api.tibiaData.enums

import androidx.annotation.DrawableRes
import app.aventurine.tibiabuddy.api.R

enum class NewsCategory(
    @DrawableRes val iconRes: Int
) {
    development(iconRes = R.drawable.newsicon_development_big),
    community(iconRes = R.drawable.newsicon_community_big),
    technical(iconRes = R.drawable.newsicon_technical_big),
    support(iconRes = R.drawable.newsicon_support_big);
}