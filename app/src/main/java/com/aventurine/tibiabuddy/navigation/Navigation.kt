package com.aventurine.tibiabuddy.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aventurine.tibiabuddy.MainViewModel
import com.aventurine.tibiabuddy.characters.CharactersScreen
import com.aventurine.tibiabuddy.characters.CharactersViewModel
import com.aventurine.tibiabuddy.map.MapScreen
import com.aventurine.tibiabuddy.map.MapViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun Navigation(
    modifier: Modifier,
    navHostController: NavHostController,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState,
    mainViewModel: MainViewModel,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    NavHost(
        navController = navHostController,
        startDestination = Main.Map.route,
        modifier = modifier
    ) {
        composable(route = Main.Map.route) { navBackStackEntry ->
            MapScreen(
                coroutineScope = coroutineScope,
                drawerState = drawerState,
                mapViewModel = viewModel(viewModelStoreOwner = viewModelStoreOwner),
                mainViewModel = mainViewModel
            )
        }

        composable(route = Main.Characters.route) { navBackStackEntry ->
            CharactersScreen(
                charactersViewModel = viewModel(viewModelStoreOwner = viewModelStoreOwner)
            )
        }
    }
}