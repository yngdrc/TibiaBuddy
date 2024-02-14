package com.aventurine.tibiabuddy.navigation

import com.aventurine.tibiabuddy.R


interface Screen {
    val route: String
    val screenIndex: Int
    val iconRes: Int

    companion object {
        fun getScreenTitle(screenIndex: Int): String = when (screenIndex) {
            Main.Map.screenIndex -> Main.Map.route
            Main.Characters.screenIndex -> Main.Characters.route
            else -> TODO()
        }
    }
}

sealed class Main(
    override val route: String,
    override val screenIndex: Int,
    override val iconRes: Int
) : Screen {
    data object Map : Main(
        route = "Map",
        screenIndex = 0,
        iconRes = R.drawable.icon_cyclopedia_map
    )

    data object Characters : Main(
        route = "Characters",
        screenIndex = 1,
        iconRes = R.drawable.icon_cyclopedia_characterinfo
    )
}