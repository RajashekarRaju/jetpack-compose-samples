package com.developersbreach.jetpackcomposesamples.ui.category.constraitLayout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.developersbreach.jetpackcomposesamples.ui.common.CategoryAppBar
import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme

@Preview("ConstraintLayout Dark Preview", widthDp = 360, heightDp = 640)
@Composable
fun PreviewDarkConstraintLayoutDark() {
    ComposeTheme(darkTheme = true) {
        ConstraintLayouts(navigateUp = { })
    }
}

@Composable
fun ConstraintLayouts(
    navigateUp: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                CategoryAppBar(
                    navigateUp = navigateUp,
                    title = "ConstraintLayout"
                )
            }
        ) {
            LayoutBody()
        }
    }
}

@Composable
fun LayoutBody() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (button, text) = createRefs()

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start, margin = 16.dp)
            },
        ) {
            Text(
                text = "Button",
                style = MaterialTheme.typography.h5
            )
        }

        Text(
            modifier = Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
                start.linkTo(button.start)
            },
            text = "I am text.",
            style = MaterialTheme.typography.h3
        )
    }
}
