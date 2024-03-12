package app.aventurine.tibiabuddy.navigation

import app.aventurine.tibiabuddy.R

interface NavigationScreen {
    val route: String
    val iconRes: Int
}

sealed class Main(
    override val route: String,
    override val iconRes: Int
) : NavigationScreen {

    data object News : Main(
        route = "News",
        iconRes = R.drawable.icon_news_client_features
    )

    data object Map : Main(
        route = "Map",
        iconRes = R.drawable.icon_cyclopedia_map
    )

    data object Characters : Main(
        route = "Characters",
        iconRes = R.drawable.icon_cyclopedia_characterinfo
    )
}