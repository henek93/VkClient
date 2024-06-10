package com.example.vkclient.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.vkclient.domain.FeedPost

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    newFeedScreenContent: @Composable () -> Unit,
    favouriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        homeScreenNavGraph(
            newFeedScreenContent = newFeedScreenContent,
            commentsScreenContent = commentsScreenContent
        )
        composable(route = Screen.Profile.route){
            profileScreenContent()
        }
        composable(route = Screen.Favourite.route){
            favouriteScreenContent()
        }
    }
}