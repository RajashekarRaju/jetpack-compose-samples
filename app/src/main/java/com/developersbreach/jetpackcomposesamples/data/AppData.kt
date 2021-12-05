package com.developersbreach.jetpackcomposesamples.data

import com.developersbreach.jetpackcomposesamples.model.*

class AppData {

    val categoriesData by lazy {
        listOf(
            Category(1, "Canvas"),
            Category(2, "List Animations"),
            Category(3, "Material Components"),
            Category(4, "Layouts"),
            Category(5, "Navigation")
        )
    }

    val canvasData by lazy {
        listOf(
            Canvas(1, "Hourglass draw and animate "),
            Canvas(2, "Numbers: draw and animate"),
            Canvas(3, "Draw compose logo")
        )
    }

    val listAnimationsData by lazy {
        listOf(
            ListAnimation(1, "Add Item to List"),
            ListAnimation(2, "Swipe to Delete"),
            ListAnimation(3, "Drag to Reorder")
        )
    }

    val materialComponentData by lazy {
        listOf(
            MaterialComponent(1, "BottomNavigationView"),
            MaterialComponent(2, "Navigation Drawer"),
            MaterialComponent(3, "Navigation Rail")
        )
    }

    val layoutsData by lazy {
        listOf(
            Layout(1, "ConstraintLayout"),
            Layout(2, "Column"),
            Layout(3, "Row"),
            Layout(4, "Box")
        )
    }

    val navigationData by lazy {
        listOf(
            Navigation(1, "List to Detail"),
            Navigation(2, "Nested Navigation")
        )
    }
}