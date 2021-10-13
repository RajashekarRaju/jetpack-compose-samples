package com.developersbreach.jetpackcomposesamples.ui.categoryList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
            CategoryListBody(selectedCategory)
        }
    }
}

@Composable
fun CategoryListBody(
    selectedCategory: (Int) -> Unit
) {
    // Save the scroll state of categories list
    val scrollState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(top = 16.dp),
        state = scrollState,
        horizontalAlignment = Alignment.Start,
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

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.surface)
            .clickable {
                selectedCategory(category.categoryNameId)
            }
    ) {
        Text(
            text = category.categoryName,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview("CategoryList Dark Preview", widthDp = 360, heightDp = 640)
@Composable
fun PreviewDarkCategoryList() {
    ComposeTheme(darkTheme = true) {
        CategoryList(selectedCategory = { })
    }
}

// @Preview("CategoryList Light Preview", widthDp = 360, heightDp = 640)
// @Composable
// fun PreviewLightCategoryList() {
//     ComposeTheme(darkTheme = false) {
//         CategoryList(selectedCategory = { })
//     }
// }