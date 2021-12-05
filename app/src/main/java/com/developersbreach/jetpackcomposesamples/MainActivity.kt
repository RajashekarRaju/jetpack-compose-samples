package com.developersbreach.jetpackcomposesamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.developersbreach.jetpackcomposesamples.navigation.AppNavigation
import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTheme {
                AppNavigation()
            }
        }
    }
}