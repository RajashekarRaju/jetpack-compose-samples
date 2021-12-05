package com.developersbreach.jetpackcomposesamples.categories.destination

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.developersbreach.jetpackcomposesamples.categories.CategoriesViewModel
import com.developersbreach.jetpackcomposesamples.ui.components.CategoryAppBar
import com.developersbreach.jetpackcomposesamples.ui.components.TitleOfTheCategory


@Composable
fun NavigationsDestination(
    selectedCategory: (Int) -> Unit,
    navigateUp: () -> Unit,
    categoriesViewModel: CategoriesViewModel
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                CategoryAppBar(
                    navigateUp = navigateUp,
                    title = "Navigation"
                )
            }
        ) {
            NavigationCategories(selectedCategory, categoriesViewModel)
        }
    }
}

@Composable
fun NavigationCategories(
    selectedCategory: (Int) -> Unit,
    categoriesViewModel: CategoriesViewModel
) {
    // Save the scroll state of categories list
    val scrollState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        state = scrollState,
        horizontalAlignment = Alignment.Start,
    ) {
        items(categoriesViewModel.getNavigationList) { item ->
            TitleOfTheCategory(selectedCategory, item.categoryId, item.categoryName)
        }
    }
}