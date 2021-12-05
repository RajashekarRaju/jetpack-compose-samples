package com.developersbreach.jetpackcomposesamples.ui.layouts.constraitLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.developersbreach.jetpackcomposesamples.R
import com.developersbreach.jetpackcomposesamples.ui.components.CategoryAppBar
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
        modifier = Modifier.fillMaxSize(),
    ) {

        val (image_1, title_1, subtitle_1) = createRefs()
        val (image_2, title_2, subtitle_2) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.firebase),
            contentDescription = "Firebase Image",
            modifier = Modifier
                .size(80.dp)
                .constrainAs(image_1) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Text(
            text = "Firebase",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.constrainAs(title_1) {
                top.linkTo(image_1.top)
                start.linkTo(image_1.end, margin = 16.dp)
            }
        )

        Text(
            text = "Product building tools",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.constrainAs(subtitle_1) {
                top.linkTo(title_1.bottom, margin = 8.dp)
                start.linkTo(title_1.start)
            }
        )

        Image(
            painter = painterResource(id = R.drawable.kotlin_2x),
            contentDescription = "Kotlin Image",
            modifier = Modifier
                .size(80.dp)
                .constrainAs(image_2) {
                    top.linkTo(image_1.bottom, margin = 28.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Text(
            text = "Kotlin",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.constrainAs(title_2) {
                top.linkTo(image_2.top)
                start.linkTo(image_2.end, margin = 16.dp)
            }
        )

        Text(
            text = "Programming language",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.constrainAs(subtitle_2) {
                top.linkTo(title_2.bottom, margin = 8.dp)
                start.linkTo(title_2.start)
            }
        )
    }
}
