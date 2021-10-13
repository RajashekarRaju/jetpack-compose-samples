package com.developersbreach.jetpackcomposesamples.ui.listAnimations.addItemToList

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import com.developersbreach.jetpackcomposesamples.R


@Composable
fun Particle(
    modifier: Modifier,
    isFired: Boolean,
    color: Color,
    onCompleteAnim: () -> Unit
) {
    val radiusDp = dimensionResource(id = R.dimen.particle_radius)
    val radius: Float
    val topPadding: Float
    val itemHeight: Float

    with(LocalDensity.current) {
        radius = radiusDp.toPx()
        topPadding = dimensionResource(id = R.dimen.list_top_padding).toPx()
        itemHeight = dimensionResource(id = R.dimen.image_size).toPx()
    }

    var topTranslation by remember { mutableStateOf(0f) }

    Canvas(modifier.size(radiusDp * 2)) {
        translate(top = topTranslation) {
            drawCircle(
                color = color,
                radius = radius
            )
        }
    }

    val animatedTopTranslation = remember { Animatable(0f) }

    LaunchedEffect(isFired) {
        if (isFired) {
            animatedTopTranslation.animateTo(
                targetValue = radius + topPadding + itemHeight / 2,
                animationSpec = spring(
                    stiffness = Spring.StiffnessLow
                )
            ) {
                topTranslation = value
            }
            animatedTopTranslation.snapTo(0f)
            topTranslation = 0f
            onCompleteAnim()
        }
    }
}
