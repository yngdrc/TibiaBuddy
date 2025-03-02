package app.aventurine.tibiabuddy.ui.map

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.aventurine.tibiabuddy.R
import ovh.plrapps.mapcompose.ui.MapUI

@Composable
fun MapScreen(
    mapViewModel: MapViewModel = hiltViewModel()
) {
    val mapUiState by mapViewModel.mapUiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            Column {
                MapFloatingActionButton(iconRes = R.drawable.icon_arrow_up) {
                    mapViewModel.setFloorId(floorId = mapUiState.floorId - 1)
                }

                MapFloatingActionButton(iconRes = R.drawable.icon_arrow_up) {
                    mapViewModel.setFloorId(floorId = mapUiState.floorId + 1)
                }
            }
        }
    ) { paddingValues ->
        MapUI(
            modifier = Modifier.padding(paddingValues),
            state = mapViewModel.mapState
        )
    }
}

@Composable
fun MapFloatingActionButton(
    @DrawableRes iconRes: Int,
    onClick: () -> Unit
) {
    SmallFloatingActionButton(
        onClick = { onClick() }
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "",
            modifier = Modifier.size(20.dp)
        )
    }
}