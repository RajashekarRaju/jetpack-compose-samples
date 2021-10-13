package com.developersbreach.jetpackcomposesamples

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developersbreach.jetpackcomposesamples.ui.bottomNav.BottomNavigationView
import com.developersbreach.jetpackcomposesamples.ui.layouts.column.ColumnLayout
import com.developersbreach.jetpackcomposesamples.ui.categoryList.CategoryList
import com.developersbreach.jetpackcomposesamples.ui.layouts.constraitLayout.ConstraintLayouts
import com.developersbreach.jetpackcomposesamples.ui.composeLogo.ComposeLogo
import com.developersbreach.jetpackcomposesamples.ui.hourglass.HourglassAnimation
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.ListAnimations
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.addItemToList.AddItemToListAnimation
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.dragToReorder.DragToReorderAnimation
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.swipeToDelete.SwipeToDeleteAnimation

/**
 * Destinations used in the App.
 */
private object AppDestinations {

    const val CATEGORIES = "list of categories"
    const val CATEGORY_CONSTRAINT_LAYOUT = "constraint layout category"
    const val CATEGORY_COLUMN_LAYOUT = "column layout category"
    const val CATEGORY_LOGO = "logo"
    const val CATEGORY_HOURGLASS_ANIMATION = "hourglass animation"
    const val CATEGORY_BOTTOM_NAVIGATION_VIEW = "bottom navigation view"
    const val CATEGORY_LIST_ANIMATIONS = "list animations"

    object ListAnimationsCategory {
        const val ADD_ITEM_TO_LIST = "add item to list"
        const val SWIPE_TO_DELETE = "swipe to delete"
        const val DRAG_TO_REORDER = "drag to reorder"
    }
}

@ExperimentalFoundationApi
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

        composable(AppDestinations.CATEGORY_LOGO) {
            ComposeLogo(
                navigateUp = actions.navigateUp
            )
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

        composable(AppDestinations.CATEGORY_HOURGLASS_ANIMATION) {
            HourglassAnimation(
                navigateUp = actions.navigateUp
            )
        }

        composable(AppDestinations.CATEGORY_BOTTOM_NAVIGATION_VIEW) {
            BottomNavigationView()
        }

        composable(AppDestinations.CATEGORY_LIST_ANIMATIONS) {
            ListAnimations(
                selectedAnimationCategory = actions.animationsCategory,
                navigateUp = actions.navigateUp
            )
        }

        composable(
            AppDestinations.ListAnimationsCategory.ADD_ITEM_TO_LIST
        ) {
            AddItemToListAnimation(
                navigateUp = actions.navigateUp
            )
        }

        composable(
            AppDestinations.ListAnimationsCategory.SWIPE_TO_DELETE
        ) {
            SwipeToDeleteAnimation(
                navigateUp = actions.navigateUp
            )
        }

        composable(
            AppDestinations.ListAnimationsCategory.DRAG_TO_REORDER
        ) {
            DragToReorderAnimation(
                navigateUp = actions.navigateUp
            )
        }
    }
}

private class AppActions(
    navController: NavHostController
) {
    val category: (Int) -> Unit = { selectedCategory: Int ->
        when (selectedCategory) {
            1 -> navController.navigate(AppDestinations.CATEGORY_CONSTRAINT_LAYOUT)
            2 -> navController.navigate(AppDestinations.CATEGORY_COLUMN_LAYOUT)
            4 -> navController.navigate(AppDestinations.CATEGORY_HOURGLASS_ANIMATION)
            7 -> navController.navigate(AppDestinations.CATEGORY_BOTTOM_NAVIGATION_VIEW)
            8 -> navController.navigate(AppDestinations.CATEGORY_LIST_ANIMATIONS)
            0 -> navController.navigate(AppDestinations.CATEGORY_LOGO)
        }
    }

    val animationsCategory: (Int) -> Unit = { selectedAnimationsCategory: Int ->
        when (selectedAnimationsCategory) {
            1 -> navController.navigate(AppDestinations.ListAnimationsCategory.ADD_ITEM_TO_LIST)
            2 -> navController.navigate(AppDestinations.ListAnimationsCategory.SWIPE_TO_DELETE)
            3 -> navController.navigate(AppDestinations.ListAnimationsCategory.DRAG_TO_REORDER)
        }
    }

    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}
