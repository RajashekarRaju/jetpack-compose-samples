package com.developersbreach.jetpackcomposesamples.ui.layouts.column

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.developersbreach.jetpackcomposesamples.ui.components.CategoryAppBar
import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme

@Preview("ColumnLayout Dark Preview", widthDp = 360, heightDp = 640)
@Composable
fun PreviewDarkColumnLayoutDark() {
    ComposeTheme(darkTheme = true) {
        ColumnLayout(navigateUp = { })
    }
}

@Composable
fun ColumnLayout(
    navigateUp: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                CategoryAppBar(
                    navigateUp = navigateUp,
                    title = "ColumnLayout"
                )
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

            }
        }
    }
}