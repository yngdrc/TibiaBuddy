package com.aventurine.tibiabuddy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aventurine.tibiabuddy.map.MapViewModel
import com.aventurine.tibiabuddy.navigation.Main
import com.aventurine.tibiabuddy.navigation.Navigation

@Composable
fun MainScreen() {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navHostController = rememberNavController()
    val navBackStackEntry = navHostController.currentBackStackEntryAsState()
    val mapViewModel: MapViewModel = viewModel()

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
            }
        }
    ) {
        Scaffold(
            containerColor = Color.Black
        ) { paddingValues ->
            Navigation(
                modifier = Modifier.padding(paddingValues),
                navHostController = navHostController,
                mapViewModel = mapViewModel,
                coroutineScope = coroutineScope,
                drawerState = drawerState
            )
        }
    }
}