package com.developersbreach.jetpackcomposesamples.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.developersbreach.jetpackcomposesamples.R

private val MontserratAlternatives = FontFamily(
    Font(R.font.montserrat_alternates_light, FontWeight.W300),
    Font(R.font.montserrat_alternates_regular, FontWeight.W400),
    Font(R.font.montserrat_alternates_medium, FontWeight.W500),
    Font(R.font.montserrat_alternates_semibold, FontWeight.W600),
    Font(R.font.montserrat_alternates_bold, FontWeight.W700),
)

// Material typography styles
val Typography = Typography(

    h3 = TextStyle(
        fontFamily = MontserratAlternatives,
        fontWeight = FontWeight.W800,
        fontSize = 32.sp
    ),
    h4 = TextStyle(
        fontFamily = MontserratAlternatives,
        fontWeight = FontWeight.W700,
        fontSize = 32.sp
    ),
    h5 = TextStyle(
        fontFamily = MontserratAlternatives,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = MontserratAlternatives,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = MontserratAlternatives,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = MontserratAlternatives,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = MontserratAlternatives,
        fontSize = 14.sp
    ),
)