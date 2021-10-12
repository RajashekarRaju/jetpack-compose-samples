package com.developersbreach.jetpackcomposesamples.ui.bottomNav

import com.developersbreach.jetpackcomposesamples.R

sealed class BottomNavItems(
    val route: String,
    val name: String,
    val icon: Int
) {
    object Contacts : BottomNavItems("contacts", "Contacts", R.drawable.contacts)
    object Recent : BottomNavItems("recent", "Recent", R.drawable.recent)
    object Favorites : BottomNavItems("account", "Favorites", R.drawable.favorite)
}

val navItems = listOf(
    BottomNavItems.Contacts,
    BottomNavItems.Recent,
    BottomNavItems.Favorites
)