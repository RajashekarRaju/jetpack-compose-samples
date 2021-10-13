package com.developersbreach.jetpackcomposesamples.ui

data class ItemListAnimations(
    val ItemAnimationId: Int,
    val ItemAnimationName: String
) {

    companion object {

        val itemsAnimationsData = listOf(
            ItemListAnimations(1, "Add Item to List"),
            ItemListAnimations(2, "Swipe to Delete"),
            ItemListAnimations(3, "Drag to Reorder")
        )
    }
}