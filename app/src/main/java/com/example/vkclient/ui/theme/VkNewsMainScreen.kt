package com.example.vkclient.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.firstcomposeproject.ui.theme.MainViewModel
import com.example.firstcomposeproject.ui.theme.NavigationItem
import com.example.vkclient.navigation.AppNavGraph
import com.example.vkclient.navigation.NavigationState
import com.example.vkclient.navigation.rememberNavigationState


@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val navigationState = rememberNavigationState()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.Black,
                contentColor = Color.Black
            ) {
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val currentRout = navBackStackEntry?.destination?.route
                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                items.forEach { item ->
                    BottomNavigationItem(
                        selected = currentRout == item.screen.route,
                        onClick = {
                            navigationState.navigateTo(item.screen.route)
                        },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        selectedContentColor = Color.Black,
                        unselectedContentColor = Color.DarkGray
                    )
                }
            }
        }
    ) { paddingValues ->
        AppNavGraph(
            navHostController = navigationState.navHostController,
            homeScreenContent = {
                HomeScreen(
                    viewModel = viewModel,
                    paddingValues = paddingValues
                )
            },
            favouriteScreenContent = { TextCounter(name = "Favourite") },
            profileScreenContent = { TextCounter(name = "Profile") }
        )
    }
}

@Composable
private fun TextCounter(name: String) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }

    androidx.compose.material.Text(
        modifier = Modifier.clickable { count++ },
        text = "$name Count: $count",
        color = Color.White
    )
}