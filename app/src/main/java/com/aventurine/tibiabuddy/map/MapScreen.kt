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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aventurine.cheminsight.android.presentation.dashboard.MapViewModel
import com.aventurine.tibiabuddy.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ovh.plrapps.mapcompose.ui.MapUI

@Composable
fun MapScreen(
    mapViewModel: MapViewModel,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState
) {
    Scaffold(
//            topBar = {
//                TopAppBar(
//                    title = { Text(text = Screen.getScreenTitle(screenIndex = pagerState.currentPage)) },
//                    colors = TopAppBarDefaults.topAppBarColors(titleContentColor = Color.Black)
//                )
//            },
        floatingActionButton = {
            Column {
                SmallFloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
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
                        mapViewModel.changeLevel(newLevel = mapViewModel.level.intValue - 1)
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
                        mapViewModel.changeLevel(newLevel = mapViewModel.level.intValue + 1)
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
        Box(modifier = Modifier.padding(paddingValues)) {
            MapContainer(viewModel = mapViewModel)
        }
    }
}

@Composable
fun MapContainer(
    viewModel: MapViewModel
) {
    MapUI(state = viewModel.mapState)
}