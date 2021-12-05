@file:Suppress("SpellCheckingInspection")

package com.developersbreach.jetpackcomposesamples.ui.materialComponents.bottomNav

import androidx.compose.ui.graphics.Color

fun pickRandomColor() = Color(
    arrayListOf(
        0xFFE57373, 0xFFBA68C8, 0xFF9575CD, 0xFFF06292,
        0xFF64B5F6, 0xFF4DD0E1, 0xFFFF8A65,
        0xFFFFD54F, 0xFF81C784, 0xFFFFF176,
    ).random()
)

fun pickRandomTimeData(): String {
    val hours = (0..11).random()
    val minutes = (0..59).random()
    val period = listOf("am", "pm").random()
    val day = listOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat").random()
    return "$hours:$minutes $period   $day"
}

fun userData() = arrayListOf(
    "Al Pacino", "Robert De Niro", "Tommy Lee Jones", "Jon Voight", "Tim Robbins",
    "Morgan Freeman", "Ray Liotta", "Matthew McConaughey", "Christian Bale", "Joe Pesci",
    "Robert Duvall", "Antonio Banderas", "Bradley Cooper", "Johnny Depp", "Brad Pitt",
    "Emile Hirsch"
)

fun favoriteContacts() = arrayListOf(
    "Robert De Niro", "Al Pacino", "Tommy Lee Jones", "Tim Robbins", "Matthew McConaughey",
    "Christian Bale", "Antonio Banderas", "Bradley Cooper", "Emile Hirsch"
)

fun recentContacts() = arrayListOf(
    "Tommy Lee Jones", "Robert De Niro", "Al Pacino", "Tim Robbins", "Matthew McConaughey",
    "Christian Bale", "Antonio Banderas", "Bradley Cooper", "Emile Hirsch"
)