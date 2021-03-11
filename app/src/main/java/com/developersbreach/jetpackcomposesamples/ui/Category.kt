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
            Category(4, "AnimatedVisibility"),
            Category(5, "Save State"),
        )
    }
}