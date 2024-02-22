package app.aventurine.tibiabuddy

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import app.aventurine.tibiabuddy.common.composable.TibiaBuddyDrawer
import app.aventurine.tibiabuddy.navigation.Navigation

@Composable
fun TibiaBuddyScreen() {
    val navHostController = rememberNavController()
    val tibiaBuddyViewModel: TibiaBuddyViewModel = viewModel()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    TibiaBuddyDrawer(
        drawerState = drawerState,
        navHostController = navHostController,
        tibiaBuddyViewModel = tibiaBuddyViewModel
    ) {
        Scaffold { paddingValues ->
            Navigation(
                modifier = Modifier.padding(paddingValues),
                navHostController = navHostController,
                drawerState = drawerState,
                tibiaBuddyViewModel = tibiaBuddyViewModel,
                viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current)
            )
        }
    }
}