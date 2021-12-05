package com.developersbreach.jetpackcomposesamples.data


class AppRepository {

    private val appData = AppData()

    // Default destination
    val categoriesListData = appData.categoriesData

    // Main Default Categories
    val canvasCategoriesData = appData.canvasData
    val listAnimationsCategoriesData = appData.listAnimationsData
    val materialComponentsCategoriesData = appData.materialComponentData
    val layoutsCategoriesData = appData.layoutsData
    val navigationCategoriesData = appData.navigationData
}