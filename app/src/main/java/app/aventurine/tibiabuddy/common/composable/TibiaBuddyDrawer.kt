package app.aventurine.tibiabuddy.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import app.aventurine.tibiabuddy.R
import app.aventurine.tibiabuddy.TibiaBuddyViewModel
import app.aventurine.tibiabuddy.navigation.Main
import app.aventurine.tibiabuddy.navigation.NavigationScreen
import app.aventurine.tibiabuddy.ui.theme.cardBackgroundColor
import kotlinx.coroutines.flow.filter

@Composable
fun TibiaBuddyDrawer(
    drawerState: DrawerState,
    navHostController: NavHostController,
    tibiaBuddyViewModel: TibiaBuddyViewModel,
    content: @Composable () -> Unit
) {
    val navBackStackEntry = navHostController.currentBackStackEntryAsState()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = cardBackgroundColor
            ) {
                TibiaBuddyDrawerNavigationItem(
                    navigationScreen = Main.News,
                    navBackStackEntry = navBackStackEntry,
                    navHostController = navHostController
                )

                TibiaBuddyDrawerNavigationItem(
                    navigationScreen = Main.Map,
                    navBackStackEntry = navBackStackEntry,
                    navHostController = navHostController
                )

                TibiaBuddyDrawerNavigationItem(
                    navigationScreen = Main.Characters,
                    navBackStackEntry = navBackStackEntry,
                    navHostController = navHostController
                )

                OnlinePlayersItem(
                    tibiaBuddyViewModel = tibiaBuddyViewModel,
                    drawerState = drawerState
                )
            }
        },
        content = content
    )
}

@Composable
fun TibiaBuddyDrawerNavigationItem(
    navigationScreen: NavigationScreen,
    navBackStackEntry: State<NavBackStackEntry?>,
    navHostController: NavHostController
) {
    NavigationDrawerItem(
        label = { Text(text = navigationScreen.route) },
        selected = navBackStackEntry.value?.destination?.route == navigationScreen.route,
        onClick = { navHostController.navigate(route = navigationScreen.route) },
        shape = RectangleShape,
        icon = {
            Image(
                painter = painterResource(id = navigationScreen.iconRes),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}

@Composable
fun OnlinePlayersItem(
    tibiaBuddyViewModel: TibiaBuddyViewModel,
    drawerState: DrawerState
) {
    LaunchedEffect(Unit) {
        snapshotFlow { drawerState.isOpen }.filter { it }.collect {
            tibiaBuddyViewModel.getPlayersOnline()
        }
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.Bottom)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_players),
            contentDescription = null,
            modifier = Modifier.size(12.dp)
        )

        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = "${tibiaBuddyViewModel.playersOnline.intValue} Players Online",
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}