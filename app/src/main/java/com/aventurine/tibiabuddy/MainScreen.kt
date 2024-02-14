package com.aventurine.tibiabuddy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aventurine.tibiabuddy.characters.CharactersViewModel
import com.aventurine.tibiabuddy.map.MapViewModel
import com.aventurine.tibiabuddy.navigation.Main
import com.aventurine.tibiabuddy.navigation.Navigation
import javax.inject.Inject

@Composable
fun MainScreen() {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navHostController = rememberNavController()
    val navBackStackEntry = navHostController.currentBackStackEntryAsState()
    val mainViewModel: MainViewModel = viewModel()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = Main.Map.route) },
                    selected = navBackStackEntry.value?.destination?.route == Main.Map.route,
                    onClick = {
                        navHostController.navigate(route = Main.Map.route)
                    },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.icon_cyclopedia_map),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    shape = RectangleShape
                )

                NavigationDrawerItem(
                    label = { Text(text = Main.Characters.route) },
                    selected = navBackStackEntry.value?.destination?.route == Main.Characters.route,
                    onClick = {
                        navHostController.navigate(route = Main.Characters.route)
                    },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.icon_cyclopedia_characterinfo),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    shape = RectangleShape
                )

                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(Alignment.Bottom)
                        .padding(15.dp),
                    text = "Players online: ${mainViewModel.playersOnline.intValue}",
                    textAlign = TextAlign.Center
                )
            }
        }
    ) {
        Scaffold(
            containerColor = Color.Black
        ) { paddingValues ->
            Navigation(
                modifier = Modifier.padding(paddingValues),
                navHostController = navHostController,
                coroutineScope = coroutineScope,
                drawerState = drawerState,
                mainViewModel = mainViewModel,
                viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current)
            )
        }
    }
}