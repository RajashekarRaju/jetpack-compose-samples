package com.developersbreach.jetpackcomposesamples.categories

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.developersbreach.jetpackcomposesamples.ComposeSamplesApp

class CategoriesViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository = (application as ComposeSamplesApp).repository

    val getCategoriesList = repository.categoriesListData
    val getCanvasList = repository.canvasCategoriesData
    val getListAnimationsList = repository.listAnimationsCategoriesData
    val getMaterialComponentsList = repository.materialComponentsCategoriesData
    val getLayoutList = repository.layoutsCategoriesData
    val getNavigationList = repository.navigationCategoriesData
}