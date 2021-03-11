package com.developersbreach.jetpackcomposesamples.ui.categoryList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developersbreach.jetpackcomposesamples.R
import com.developersbreach.jetpackcomposesamples.ui.Category
import com.developersbreach.jetpackcomposesamples.ui.Category.Companion.categories
import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme

@Composable
fun CategoryList(
    selectedCategory: (Int) -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                Text(
                    text = stringResource(id = R.string.app_bar_title),
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    textAlign = TextAlign.Center
                )
            }
        ) {
            CategoryListBody(selectedCategory)
        }
    }
}

@Composable
fun CategoryListBody(
    selectedCategory: (Int) -> Unit
) {

    // Save the scroll state of cats list
    val scrollState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = scrollState,
        horizontalAlignment = Alignment.Start
    ) {
        items(categories) { category ->
            ItemCategory(category, selectedCategory)
        }
    }
}

@Composable
fun ItemCategory(
    category: Category,
    selectedCategory: (Int) -> Unit
) {
    Text(
        text = category.categoryName,
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                selectedCategory(category.categoryNameId)
            }
            .padding(16.dp)
    )
}

@Preview("Category List Light Preview", widthDp = 360, heightDp = 640)
@Composable
fun PreviewLightCategoryList() {
    ComposeTheme(darkTheme = false) {
        CategoryList(selectedCategory = { })
    }
}

@Preview("Category List Dark Preview", widthDp = 360, heightDp = 640)
@Composable
fun PreviewDarkCategoryList() {
    ComposeTheme(darkTheme = true) {
        CategoryList(selectedCategory = { })
    }
}