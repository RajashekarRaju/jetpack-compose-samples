package com.developersbreach.jetpackcomposesamples.ui.hourglass

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color

@Composable
fun scaleShapeTransition(
    initialValue: Float,
    targetValue: Float,
    durationMillis: Int
): Float {
    val infiniteTransition = rememberInfiniteTransition()
    val scale: Float by infiniteTransition.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis),
            repeatMode = RepeatMode.Restart
        )
    )

    return scale
}

@Composable
fun colorShapeTransition(
    initialValue: Color,
    targetValue: Color,
    durationMillis: Int
): Color {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    return color
}