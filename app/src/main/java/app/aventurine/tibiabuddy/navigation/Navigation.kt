package app.aventurine.tibiabuddy.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.aventurine.tibiabuddy.TibiaBuddyViewModel
import app.aventurine.tibiabuddy.characters.CharactersScreen
import app.aventurine.tibiabuddy.map.MapScreen
import app.aventurine.tibiabuddy.news.NewsScreen

@Composable
fun Navigation(
    modifier: Modifier,
    navHostController: NavHostController,
    drawerState: DrawerState,
    tibiaBuddyViewModel: TibiaBuddyViewModel,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    NavHost(
        navController = navHostController,
        startDestination = Main.News.route,
        modifier = modifier
    ) {
        composable(route = Main.News.route) { navBackStackEntry ->
            NewsScreen(
                newsViewModel = viewModel(viewModelStoreOwner = viewModelStoreOwner)
            )
        }

        composable(route = Main.Map.route) { navBackStackEntry ->
            MapScreen(
                drawerState = drawerState,
                mapViewModel = viewModel(viewModelStoreOwner = viewModelStoreOwner),
                tibiaBuddyViewModel = tibiaBuddyViewModel
            )
        }

        composable(route = Main.Characters.route) { navBackStackEntry ->
            CharactersScreen(
                charactersViewModel = viewModel(viewModelStoreOwner = viewModelStoreOwner)
            )
        }
    }
}