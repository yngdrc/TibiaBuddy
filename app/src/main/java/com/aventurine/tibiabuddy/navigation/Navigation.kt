package com.aventurine.cheminsight.android.presentation.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aventurine.tibiabuddy.map.MapScreen
import com.aventurine.cheminsight.android.presentation.dashboard.MapViewModel
import com.aventurine.tibiabuddy.navigation.Main
import kotlinx.coroutines.CoroutineScope

@Composable
fun Navigation(
    modifier: Modifier,
    navHostController: NavHostController,
    mapViewModel: MapViewModel,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState
) {
    NavHost(
        navController = navHostController,
        startDestination = Main.Map.route,
        modifier = modifier
    ) {
        composable(route = Main.Map.route) { navBackStackEntry ->
            MapScreen(
                mapViewModel = mapViewModel,
                coroutineScope = coroutineScope,
                drawerState = drawerState
            )
        }
    }
}