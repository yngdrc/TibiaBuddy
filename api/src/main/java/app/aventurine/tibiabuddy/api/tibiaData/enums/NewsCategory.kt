package app.aventurine.tibiabuddy.api.tibiaData.enums

import androidx.annotation.DrawableRes
import app.aventurine.tibiabuddy.api.R

enum class NewsCategory(
    @DrawableRes val smallIconRes: Int,
    @DrawableRes val bigIconRes: Int
) {
    cipsoft(
        smallIconRes = R.drawable.newsicon_cipsoft_small,
        bigIconRes = R.drawable.newsicon_cipsoft_big
    ),

    development(
        smallIconRes = R.drawable.newsicon_development_small,
        bigIconRes = R.drawable.newsicon_development_big
    ),

    community(
        smallIconRes = R.drawable.newsicon_community_small,
        bigIconRes = R.drawable.newsicon_community_big
    ),

    technical(
        smallIconRes = R.drawable.newsicon_technical_small,
        bigIconRes = R.drawable.newsicon_technical_big
    ),

    support(
        smallIconRes = R.drawable.newsicon_support_small,
        bigIconRes = R.drawable.newsicon_support_big
    )
}