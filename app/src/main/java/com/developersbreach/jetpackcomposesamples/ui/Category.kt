package com.developersbreach.jetpackcomposesamples.ui

data class Category(
    val categoryNameId: Int,
    val categoryName: String
) {

    companion object {

        val categories = listOf(
            Category(1, "ConstraintLayout"),
            Category(2, "ColumnLayout"),
            Category(3, "RowLayout"),
            Category(4, "Hourglass Animation"),
            Category(5, "AnimatedVisibility"),
            Category(6, "Save State"),
            Category(7, "Bottom Navigation View"),
        )
    }
}