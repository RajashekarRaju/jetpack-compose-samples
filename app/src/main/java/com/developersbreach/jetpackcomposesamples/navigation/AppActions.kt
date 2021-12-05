package com.developersbreach.jetpackcomposesamples.navigation

import androidx.navigation.NavHostController


class AppActions(
    private val navController: NavHostController,
    destination: AppDestinations
) {

    private fun navigateTo(destination: String) {
        return navController.navigate(destination)
    }

    val mainCategories: (Int) -> Unit = { selectedCategory: Int ->
        when (selectedCategory) {
            1 -> navigateTo(destination.CANVAS_MAIN_CATEGORY_DESTINATION)
            2 -> navigateTo(destination.LIST_ANIMATIONS_MAIN_CATEGORY_DESTINATION)
            3 -> navigateTo(destination.MATERIAL_COMPONENTS_MAIN_CATEGORY_DESTINATION)
            4 -> navigateTo(destination.LAYOUTS_MAIN_CATEGORY_DESTINATION)
            5 -> navigateTo(destination.NAVIGATION_MAIN_CATEGORY_DESTINATION)
        }
    }

    val canvasCategories: (Int) -> Unit = { selectedCategory ->
        val canvasDestination = AppDestinations.CanvasCategory
        when (selectedCategory) {
            1 -> navigateTo(canvasDestination.HOURGLASS_ANIMATION_DESTINATION)
            2 -> navigateTo(canvasDestination.NUMBERS_ANIMATION_DESTINATION)
            3 -> navigateTo(canvasDestination.DRAW_COMPOSE_DESTINATION)
        }
    }

    val listAnimationsCategory: (Int) -> Unit = { selectedCategory: Int ->
        val listAnimationsCategory = AppDestinations.ListAnimationsCategory
        when (selectedCategory) {
            1 -> navigateTo(listAnimationsCategory.ADD_ITEM_TO_LIST)
            2 -> navigateTo(listAnimationsCategory.SWIPE_TO_DELETE)
            3 -> navigateTo(listAnimationsCategory.DRAG_TO_REORDER)
        }
    }

    val materialComponentsCategory: (Int) -> Unit = { selectedCategory: Int ->
        val materialComponentsCategory = AppDestinations.MaterialComponentsCategory
        when (selectedCategory) {
            1 -> navigateTo(materialComponentsCategory.BOTTOM_NAVIGATION_VIEW_DESTINATION)
            2 -> navigateTo(materialComponentsCategory.NAVIGATION_DRAWER_DESTINATION)
            3 -> navigateTo(materialComponentsCategory.NAVIGATION_RAIL_DESTINATION)
        }
    }

    val layoutsCategory: (Int) -> Unit = { selectedCategory: Int ->
        val layoutsCategory = AppDestinations.LayoutsCategory
        when (selectedCategory) {
            1 -> navigateTo(layoutsCategory.CONSTRAINT_LAYOUT_DESTINATION)
            2 -> navigateTo(layoutsCategory.COLUMN_LAYOUT_DESTINATION)
            3 -> navigateTo(layoutsCategory.ROW_LAYOUT_DESTINATION)
            4 -> navigateTo(layoutsCategory.BOX_LAYOUT_DESTINATION)
        }
    }

    val navigationCategory: (Int) -> Unit = { selectedCategory: Int ->
        val navigationCategory = AppDestinations.NavigationCategory
        when (selectedCategory) {
            1 -> navigateTo(navigationCategory.LIST_TO_DETAIL_DESTINATION)
            2 -> navigateTo(navigationCategory.NESTED_NAVIGATION_DESTINATION)
        }
    }

    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}
