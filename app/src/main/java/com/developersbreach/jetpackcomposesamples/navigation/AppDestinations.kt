package com.developersbreach.jetpackcomposesamples.navigation

/**
 * Destinations used in the App.
 */
object AppDestinations {

    // Destination for Main Categories
    const val HOME_DESTINATION_CATEGORY = "list of main categories in  home screen"

    // Categories visible in Main Categories
    const val CANVAS_MAIN_CATEGORY_DESTINATION = "main to canvas categories destination"
    const val LIST_ANIMATIONS_MAIN_CATEGORY_DESTINATION = "main to list animations categories destination"
    const val MATERIAL_COMPONENTS_MAIN_CATEGORY_DESTINATION = "main to material components categories destination"
    const val LAYOUTS_MAIN_CATEGORY_DESTINATION = "main to layouts categories destination"
    const val NAVIGATION_MAIN_CATEGORY_DESTINATION = "main to navigation categories destination"

    object CanvasCategory {
        const val HOURGLASS_ANIMATION_DESTINATION = "hourglass animation"
        const val NUMBERS_ANIMATION_DESTINATION = "numbers animation"
        const val DRAW_COMPOSE_DESTINATION = "draw compose logo"
    }

    object ListAnimationsCategory {
        const val ADD_ITEM_TO_LIST = "add item to list"
        const val SWIPE_TO_DELETE = "swipe to delete"
        const val DRAG_TO_REORDER = "drag to reorder"
    }

    object MaterialComponentsCategory {
        const val BOTTOM_NAVIGATION_VIEW_DESTINATION = "bottom navigation view"
        const val NAVIGATION_DRAWER_DESTINATION = "navigation drawer destination"
        const val NAVIGATION_RAIL_DESTINATION = "navigation rail"
    }

    object LayoutsCategory {
        const val CONSTRAINT_LAYOUT_DESTINATION = "constraint layout"
        const val COLUMN_LAYOUT_DESTINATION = "columns"
        const val ROW_LAYOUT_DESTINATION = "rows"
        const val BOX_LAYOUT_DESTINATION = "box"
    }

    object NavigationCategory {
        const val LIST_TO_DETAIL_DESTINATION = "list to detail navigation"
        const val NESTED_NAVIGATION_DESTINATION = "nested navigation"
    }
}