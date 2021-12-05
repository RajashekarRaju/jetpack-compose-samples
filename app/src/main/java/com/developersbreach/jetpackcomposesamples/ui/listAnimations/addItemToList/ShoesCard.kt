package com.developersbreach.jetpackcomposesamples.ui.listAnimations.addItemToList

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developersbreach.jetpackcomposesamples.R
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.model.ShoesArticle
import kotlin.math.hypot


private var maxRadiusPx = 0f

@Composable
fun ShoesCard(
    shoesArticle: ShoesArticle,
    isVisible: Boolean
) {

    val particleRadius: Float
    with(LocalDensity.current) {
        particleRadius = dimensionResource(id = R.dimen.particle_radius).toPx()
    }
    var radius by remember { mutableStateOf(particleRadius) }
    var visibilityAlpha by remember { mutableStateOf(0f) }

    Box(
        Modifier.padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(
                    color = Color.Transparent
                )
                .onGloballyPositioned { coordinates ->
                    if (maxRadiusPx == 0f) {
                        maxRadiusPx =
                            hypot(coordinates.size.width / 2f, coordinates.size.height / 2f)
                    }
                }
                .drawBehind {
                    drawCircle(
                        color = if (isVisible) shoesArticle.color else Color.Transparent,
                        radius = radius
                    )
                }
                .padding(dimensionResource(id = R.dimen.slot_padding))
                .align(Alignment.CenterStart)
                .fillMaxWidth(),
        ) {

            Text(
                shoesArticle.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.alpha(visibilityAlpha)
            )

            Spacer(Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .alpha(visibilityAlpha),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "$ ${shoesArticle.price}",
                    fontSize = 14.sp,
                    color = Color.White
                )

                Spacer(Modifier.width(8.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )

                Spacer(Modifier.width(8.dp))

                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = shoesArticle.width,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
        }

        Image(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(dimensionResource(id = R.dimen.image_size))
                .alpha(visibilityAlpha),
            painter = painterResource(id = shoesArticle.drawable),
            contentDescription = ""
        )
    }

    val animatedRadius = remember { Animatable(particleRadius) }
    val animatedAlpha = remember { Animatable(0f) }

    LaunchedEffect(isVisible) {

        if (isVisible) {
            animatedRadius.animateTo(
                targetValue = maxRadiusPx,
                animationSpec = tween()
            ) {
                radius = value
            }

            animatedAlpha.animateTo(
                targetValue = 1f,
                animationSpec = tween()
            ) {
                visibilityAlpha = value
            }
        }
    }
}