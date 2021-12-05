package com.developersbreach.jetpackcomposesamples.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developersbreach.jetpackcomposesamples.categories.*
import com.developersbreach.jetpackcomposesamples.categories.destination.*
import com.developersbreach.jetpackcomposesamples.ui.canvas.hourglass.HourglassAnimation
import com.developersbreach.jetpackcomposesamples.ui.materialComponents.bottomNav.BottomNavigationView
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.addItemToList.AddItemToListAnimation
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.dragToReorder.DragToReorderAnimation
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.swipeToDelete.SwipeToDeleteAnimation

@Composable
fun AppNavigation(
    startDestination: String = AppDestinations.HOME_DESTINATION_CATEGORY,
    categoryViewModel: CategoriesViewModel = viewModel()
) {
    val navController = rememberNavController()
    val destinations = AppDestinations
    val actions = remember(navController) {
        AppActions(navController, destinations)
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        setMainCategoryDestination(destinations, actions, categoryViewModel)
        setCanvasDestinations(destinations, actions, categoryViewModel)
        setListAnimationsDestinations(destinations, actions, categoryViewModel)
        setMaterialComponentDestinations(destinations, actions, categoryViewModel)
        setNavigationsDestinations(destinations, actions, categoryViewModel)
        setLayoutsDestinations(destinations, actions, categoryViewModel)
    }
}

private fun NavGraphBuilder.setMainCategoryDestination(
    destinations: AppDestinations,
    actions: AppActions,
    categoryViewModel: CategoriesViewModel
) {
    composable(
        destinations.HOME_DESTINATION_CATEGORY
    ) {
        CategoryList(
            selectedCategory = actions.mainCategories,
            categoryViewModel = categoryViewModel
        )
    }
}

private fun NavGraphBuilder.setCanvasDestinations(
    destinations: AppDestinations,
    actions: AppActions,
    categoryViewModel: CategoriesViewModel
) {
    val canvasCategory = AppDestinations.CanvasCategory

    composable(destinations.CANVAS_MAIN_CATEGORY_DESTINATION) {
        CanvasDestination(
            selectedCategory = actions.canvasCategories,
            navigateUp = actions.navigateUp,
            categoryViewModel = categoryViewModel
        )
    }

    composable(
        canvasCategory.HOURGLASS_ANIMATION_DESTINATION
    ) {
        HourglassAnimation(navigateUp = actions.navigateUp)
    }

    composable(
        canvasCategory.NUMBERS_ANIMATION_DESTINATION
    ) {
        HourglassAnimation(navigateUp = actions.navigateUp)
    }

    composable(
        canvasCategory.DRAW_COMPOSE_DESTINATION
    ) {
        HourglassAnimation(navigateUp = actions.navigateUp)
    }
}

private fun NavGraphBuilder.setListAnimationsDestinations(
    destinations: AppDestinations,
    actions: AppActions,
    categoryViewModel: CategoriesViewModel
) {
    val listAnimationCategory = AppDestinations.ListAnimationsCategory

    composable(destinations.LIST_ANIMATIONS_MAIN_CATEGORY_DESTINATION) {
        ListAnimationsDestination(
            selectedCategory = actions.listAnimationsCategory,
            navigateUp = actions.navigateUp,
            categoriesViewModel = categoryViewModel
        )
    }

    composable(
        listAnimationCategory.ADD_ITEM_TO_LIST
    ) {
        AddItemToListAnimation(navigateUp = actions.navigateUp)
    }

    composable(
        listAnimationCategory.SWIPE_TO_DELETE
    ) {
        SwipeToDeleteAnimation(navigateUp = actions.navigateUp)
    }

    composable(
        listAnimationCategory.DRAG_TO_REORDER
    ) {
        DragToReorderAnimation(navigateUp = actions.navigateUp)
    }
}

private fun NavGraphBuilder.setMaterialComponentDestinations(
    destinations: AppDestinations,
    actions: AppActions,
    categoryViewModel: CategoriesViewModel
) {
    val materialComponentsCategory = AppDestinations.MaterialComponentsCategory

    composable(destinations.MATERIAL_COMPONENTS_MAIN_CATEGORY_DESTINATION) {
        MaterialComponentsDestination(
            selectedCategory = actions.materialComponentsCategory,
            navigateUp = actions.navigateUp,
            categoriesViewModel = categoryViewModel
        )
    }

    composable(
        materialComponentsCategory.BOTTOM_NAVIGATION_VIEW_DESTINATION
    ) {
        BottomNavigationView()
    }
}

private fun NavGraphBuilder.setNavigationsDestinations(
    destinations: AppDestinations,
    actions: AppActions,
    categoryViewModel: CategoriesViewModel
) {
    val navigationCategory = AppDestinations.NavigationCategory

    composable(destinations.NAVIGATION_MAIN_CATEGORY_DESTINATION) {
        NavigationsDestination(
            selectedCategory = actions.navigationCategory,
            navigateUp = actions.navigateUp,
            categoriesViewModel = categoryViewModel
        )
    }

    composable(
        navigationCategory.LIST_TO_DETAIL_DESTINATION
    ) {
        // AddItemToListAnimation(navigateUp = actions.navigateUp)
    }

    composable(
        navigationCategory.NESTED_NAVIGATION_DESTINATION
    ) {
        // SwipeToDeleteAnimation(navigateUp = actions.navigateUp)
    }
}

private fun NavGraphBuilder.setLayoutsDestinations(
    destinations: AppDestinations,
    actions: AppActions,
    categoryViewModel: CategoriesViewModel
) {
    val layoutsCategory = AppDestinations.LayoutsCategory

    composable(destinations.LAYOUTS_MAIN_CATEGORY_DESTINATION) {
        LayoutsDestination(
            selectedCategory = actions.layoutsCategory,
            navigateUp = actions.navigateUp,
            categoriesViewModel = categoryViewModel
        )
    }

    composable(
        layoutsCategory.CONSTRAINT_LAYOUT_DESTINATION
    ) {
        // AddItemToListAnimation(navigateUp = actions.navigateUp)
    }

    composable(
        layoutsCategory.COLUMN_LAYOUT_DESTINATION
    ) {
        // AddItemToListAnimation(navigateUp = actions.navigateUp)
    }

    composable(
        layoutsCategory.ROW_LAYOUT_DESTINATION
    ) {
        // AddItemToListAnimation(navigateUp = actions.navigateUp)
    }

    composable(
        layoutsCategory.BOX_LAYOUT_DESTINATION
    ) {
        // AddItemToListAnimation(navigateUp = actions.navigateUp)
    }
}