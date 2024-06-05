package com.example.firstcomposeproject.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.vkclient.R

sealed class NavigationItem(
    val titleResId: Int,
    val icon: ImageVector
) {

    object Home : NavigationItem(
        titleResId = R.string.navigation_item_main,
        icon = Icons.Default.Home
    )

    object Favourite: NavigationItem(
        titleResId = R.string.navigation_item_favourite,
        icon = Icons.Default.Favorite
    )

    object Profile: NavigationItem(
        titleResId = R.string.navigation_item_profile,
        icon = Icons.Default.Person
    )
}