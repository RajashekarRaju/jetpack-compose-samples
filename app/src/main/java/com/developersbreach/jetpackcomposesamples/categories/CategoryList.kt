package com.developersbreach.jetpackcomposesamples.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.developersbreach.jetpackcomposesamples.R
import com.developersbreach.jetpackcomposesamples.ui.components.TitleOfTheCategory
import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme


@Composable
fun CategoryList(
    selectedCategory: (Int) -> Unit,
    categoryViewModel: CategoriesViewModel
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.icon),
                        contentDescription = stringResource(R.string.content_desc_up_navigate),
                        Modifier
                            .size(80.dp)
                            .padding(start = 16.dp)
                            .clickable { selectedCategory(0) }
                    )

                    Text(
                        text = stringResource(id = R.string.app_bar_title),
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp)
                    )
                }
            }
        ) {
            CategoryListBody(selectedCategory, categoryViewModel)
        }
    }
}

@Composable
fun CategoryListBody(
    selectedCategory: (Int) -> Unit,
    categoryViewModel: CategoriesViewModel,
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
        items(categoryViewModel.getCategoriesList) { item ->
            TitleOfTheCategory(selectedCategory, item.categoryId, item.categoryName)
        }
    }
}

@Preview("CategoryList Dark Preview", widthDp = 360, heightDp = 640)
@Composable
fun PreviewDarkCategoryList() {
    ComposeTheme {
        CategoryList(selectedCategory = { }, viewModel())
    }
}