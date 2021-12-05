package com.developersbreach.jetpackcomposesamples.ui.materialComponents.bottomNav

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme


@Composable
fun BottomNavigationView() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                { SearchBar() },
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp
            )
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        NavigationHost(navController)
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<BottomNavItems> = navItems
) {

    BottomNavigation {

        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination

        items.forEach { navItem ->

            BottomNavigationItem(
                label = { Text(navItem.name) },
                alwaysShowLabel = true,
                selectedContentColor = MaterialTheme.colors.secondaryVariant,
                unselectedContentColor = MaterialTheme.colors.primaryVariant,
                selected = currentRoute?.hierarchy?.any {
                    navItem.route == it.route
                } == true,
                icon = {
                    Icon(
                        painterResource(id = navItem.icon),
                        contentDescription = navItem.name,
                    )
                },
                onClick = {
                    navController.navigate(navItem.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItems.Contacts.route
    ) {
        composable(BottomNavItems.Favorites.route) {
            FavoriteContactsScreen()
        }

        composable(BottomNavItems.Contacts.route) {
            ContactsScreen()
        }

        composable(BottomNavItems.Recent.route) {
            RecentContactsScreen()
        }
    }
}

@ExperimentalFoundationApi
@Preview(widthDp = 360, heightDp = 64)
@Composable
fun BottomNavViewPreview() {
    ComposeTheme(darkTheme = true) {
        BottomNavigationBar(rememberNavController())
    }
}