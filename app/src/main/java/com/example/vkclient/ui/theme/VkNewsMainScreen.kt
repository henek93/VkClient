package com.example.vkclient.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.firstcomposeproject.ui.theme.NavigationItem
import com.example.vkclient.domain.FeedPost


@Composable
fun MainScreen() {

    val feedPost = remember {
        mutableStateOf(FeedPost())
    }
    Scaffold(
        bottomBar = {
            BottomNavigation {
                Log.d("COMPOSE_TEST", "BottomNavigation")

                val selectedItemPosition = remember {
                    mutableStateOf(0)
                }

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = selectedItemPosition.value == index,
                        onClick = { selectedItemPosition.value = index },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedContentColor = MaterialTheme.colorScheme.onSecondary
                    )
                }
            }
        }
    ) {
        PostCard(
            modifier = Modifier.padding(8.dp).size(800.dp),
            feedPost = feedPost.value,
            onStatisticsClickListener = { newItem ->
                val oldStatistics = feedPost.value.statistics
                val newStatistics = oldStatistics.toMutableList().apply {
                    replaceAll { oldItem ->
                        if (oldItem.type == newItem.type) {
                            oldItem.copy(count = oldItem.count + 1)
                        } else {
                            oldItem
                        }
                    }
                }
                feedPost.value = feedPost.value.copy(statistics = newStatistics)
            }
        )
    }
}
