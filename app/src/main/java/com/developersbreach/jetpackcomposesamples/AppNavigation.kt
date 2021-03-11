package com.developersbreach.jetpackcomposesamples

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.developersbreach.jetpackcomposesamples.ui.category.column.ColumnLayout
import com.developersbreach.jetpackcomposesamples.ui.categoryList.CategoryList
import com.developersbreach.jetpackcomposesamples.ui.category.constraitLayout.ConstraintLayouts

/**
 * Destinations used in the App.
 */
private object AppDestinations {
    const val CATEGORIES = "list of categories"
    const val CATEGORY_CONSTRAINT_LAYOUT = "constraint layout category"
    const val CATEGORY_COLUMN_LAYOUT = "column layout category"
}

@ExperimentalAnimationApi
@Composable
fun AppNavigation(
    startDestination: String = AppDestinations.CATEGORIES
) {
    val navController = rememberNavController()
    val actions = remember(navController) { AppActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppDestinations.CATEGORIES) {
            CategoryList(selectedCategory = actions.category)
        }

        composable(AppDestinations.CATEGORY_CONSTRAINT_LAYOUT) {
            ConstraintLayouts(
                navigateUp = actions.navigateUp
            )
        }

        composable(AppDestinations.CATEGORY_COLUMN_LAYOUT) {
            ColumnLayout(
                navigateUp = actions.navigateUp
            )
        }
    }
}

private class AppActions(
    navController: NavHostController
) {
    val category: (Int) -> Unit = { selectedCategory: Int ->
        if (selectedCategory == 1) {
            navController.navigate(AppDestinations.CATEGORY_CONSTRAINT_LAYOUT)
        } else if (selectedCategory == 2) {
            navController.navigate(AppDestinations.CATEGORY_COLUMN_LAYOUT)
        }
    }

    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}
