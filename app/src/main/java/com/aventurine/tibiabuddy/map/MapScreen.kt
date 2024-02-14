package com.aventurine.tibiabuddy.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aventurine.tibiabuddy.MainViewModel
import com.aventurine.tibiabuddy.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ovh.plrapps.mapcompose.ui.MapUI
import kotlin.math.max

@Composable
fun MapScreen(
    mapViewModel: MapViewModel,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState,
    mainViewModel: MainViewModel
) {

    Scaffold(
        floatingActionButton = {
            Column {
                SmallFloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            drawerState.apply {
                                if (!isClosed)
                                    return@launch close()

                                open()
                                mainViewModel.getPlayersOnline()
                            }
                        }
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_home),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                }

                SmallFloatingActionButton(
                    onClick = {
                        mapViewModel.changeLevel(newLevel = mapViewModel.currentLevel.intValue - 1)
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.marker_green_up),
                        contentDescription = "",
                        modifier = Modifier.size(10.dp)
                    )
                }

                SmallFloatingActionButton(
                    onClick = {
                        mapViewModel.changeLevel(newLevel = mapViewModel.currentLevel.intValue + 1)
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.marker_green_down),
                        contentDescription = "",
                        modifier = Modifier.size(10.dp)
                    )
                }
            }
        },
        containerColor = Color.Black
    ) { paddingValues ->
        MapUI(modifier = Modifier.padding(paddingValues), state = mapViewModel.mapState)
    }
}