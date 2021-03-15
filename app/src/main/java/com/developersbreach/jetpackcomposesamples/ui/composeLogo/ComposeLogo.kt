package com.developersbreach.jetpackcomposesamples.ui.composeLogo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.developersbreach.jetpackcomposesamples.R
import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme

val firstTop = Color(0xFF3DDC84)
// val firstBottom = Color(0xFF37BF6E)
// val secondTop = Color(0xFF4285F4)
// val secondBottom = Color(0xFF3870B2)
// val thirdTop = Color(0xFF083042)
// val thirdBottom = Color(0xFF041619)
// val centerColor = Color(0xFFD6F0FF)

@Preview("Logo", widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreview() {
    ComposeTheme(darkTheme = true) {
        ComposeLogo { }
    }
}

@Composable
fun ComposeLogo(
    navigateUp: () -> Unit
) {

    Surface(
        color = MaterialTheme.colors.background
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (upButton, logo) = createRefs()

            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = stringResource(R.string.content_desc_up_navigate),
                    modifier = Modifier
                        .padding(8.dp)
                        .constrainAs(upButton) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                )
            }

            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(logo) {
                        centerHorizontallyTo(parent)
                        centerVerticallyTo(parent)
                    }
            ) {
                // val canvasSize = size
                val canvasWidth = size.width
                val canvasHeight = size.height

                val centerX = canvasWidth / 2
                val centerY = canvasHeight / 2

                val distance = centerY - (centerY / 1.2).toFloat()
                val distanceHor = centerY - (centerY / 1.2).toFloat()

                // val centerOffset = Offset(centerX, centerY)
                val topOffset = Offset(centerX, (centerY / 1.2).toFloat())
                val bottomOffset = Offset(centerX, centerY + distance)
                val leftBottomOffset = Offset(centerX - distanceHor, centerY + distance / 2)
                val leftTopOffset = Offset(centerX - distanceHor, centerY - distance / 2)
                val rightBottomOffset = Offset(centerX + distanceHor, centerY + distance / 2)
                val rightTopOffset = Offset(centerX + distanceHor, centerY - distance / 2)

                val lines = listOf(
                    Pair(topOffset, leftTopOffset),
                    Pair(leftTopOffset, leftBottomOffset),
                    Pair(leftBottomOffset, bottomOffset),
                    Pair(bottomOffset, rightBottomOffset),
                    Pair(rightBottomOffset, rightTopOffset),
                    Pair(rightTopOffset, topOffset),
                )

                for (line in lines) {

                    drawLine(
                        start = line.first,
                        end = line.second,
                        color = firstTop,
                        strokeWidth = 16F,
                        cap = StrokeCap.Round,
                        pathEffect = PathEffect.cornerPathEffect(400F)
                    )
                }

                // drawPoints(
                //     listOf(
                //         centerOffset,
                //         topOffset,
                //         bottomOffset,
                //         leftTopOffset,
                //         leftBottomOffset,
                //         rightTopOffset,
                //         rightBottomOffset
                //     ),
                //     pointMode = PointMode.Points,
                //     color = centerColor,
                //     strokeWidth = 16F,
                //     cap = StrokeCap.Round
                // )
            }
        }
    }
}