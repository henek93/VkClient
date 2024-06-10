package com.example.vkclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.vkclient.ui.theme.MainScreen
import com.example.vkclient.ui.theme.VkClientTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkClientTheme {
                MainScreen()
            }
        }
    }
}
