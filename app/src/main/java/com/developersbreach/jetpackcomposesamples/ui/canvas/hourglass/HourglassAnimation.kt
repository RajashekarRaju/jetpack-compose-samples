package com.developersbreach.jetpackcomposesamples.ui.canvas.hourglass

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developersbreach.jetpackcomposesamples.ui.components.CategoryAppBar
import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme
import com.developersbreach.jetpackcomposesamples.ui.theme.grey100
import com.developersbreach.jetpackcomposesamples.ui.theme.grey900

@Preview("HourglassAnimation Preview", widthDp = 360, heightDp = 640)
@Composable
fun PreviewHourglassAnimation() {
    ComposeTheme(darkTheme = true) {
        HourglassAnimation(navigateUp = { })
    }
}

@Composable
fun HourglassAnimation(
    navigateUp: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                CategoryAppBar(
                    navigateUp = navigateUp,
                    title = "Hourglass Animation"
                )
            }
        ) {
            Hourglass()
        }
    }
}

@Composable
fun Hourglass() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val scale = scaleShapeTransition(0.1f, 1f, 2000)
        val lineColor = colorShapeTransition(grey900, grey100, 2000)

        DrawRoundRectangle(scale, lineColor)
        DrawLines(scale, lineColor)
        DrawRoundRectangle(scale, lineColor)
    }
}

@Composable
fun DrawLines(
    scale: Float,
    lineColor: Color
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
    ) {
        // Left top
        drawSingleLine(340f, -20f, 340f, 140f, lineColor, this)
        // Left top diagonal
        drawSingleLine(340f, 140f, 460f, 260f, lineColor, this)
        // Left bottom diagonal
        drawSingleLine(460f, 260f, 340f, 380f, lineColor, this)
        // Left bottom
        drawSingleLine(340f, 380f, 340f, 540f, lineColor, this)
        // Right bottom
        drawSingleLine(740f, 380f, 740f, 540f, lineColor, this)
        // Right top diagonal
        drawSingleLine(740f, 140f, 620f, 260f, lineColor, this)
        // Right bottom diagonal
        drawSingleLine(620f, 260f, 740f, 380f, lineColor, this)
        // Right top
        drawSingleLine(740f, -20f, 740f, 140f, lineColor, this)
    }
}

@Composable
fun DrawRoundRectangle(
    scale: Float,
    lineColor: Color
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
    ) {
        val canvasSize = size
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawRoundRect(
            size = canvasSize / 2F,
            cornerRadius = CornerRadius(60F, 60F),
            color = lineColor,
            style = Stroke(width = 16F),
            topLeft = Offset(
                x = canvasWidth / 4F,
                y = canvasHeight / 3F
            )
        )
    }
}

fun drawSingleLine(
    startX: Float,
    startY: Float,
    endX: Float,
    endY: Float,
    lineColor: Color,
    drawScope: DrawScope
) {
    drawScope.drawLine(
        start = Offset(startX, startY),
        end = Offset(endX, endY),
        color = lineColor,
        strokeWidth = 16F,
        cap = StrokeCap.Round
    )
}
