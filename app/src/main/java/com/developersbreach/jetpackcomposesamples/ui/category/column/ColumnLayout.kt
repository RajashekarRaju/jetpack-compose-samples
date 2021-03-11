package com.developersbreach.jetpackcomposesamples.ui.category.column

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developersbreach.jetpackcomposesamples.R
import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme

@Composable
fun ColumnLayout(
    navigateUp: () -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                contentColor = Color.White,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            tint = MaterialTheme.colors.onBackground,
                            contentDescription = stringResource(R.string.content_desc_up_navigate)
                        )
                    }

                    Text(
                        text = "ColumnLayout",
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview("Column Layout Dark Preview", widthDp = 360, heightDp = 640)
@Composable
fun PreviewDarkColumnLayoutDark() {
    ComposeTheme(darkTheme = true) {
        ColumnLayout(navigateUp = { })
    }
}

@Preview("Column Layout Light Preview", widthDp = 360, heightDp = 640)
@Composable
fun PreviewLightColumnLayoutDark() {
    ComposeTheme(darkTheme = false) {
        ColumnLayout(navigateUp = { })
    }
}