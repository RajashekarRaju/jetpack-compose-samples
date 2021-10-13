package com.developersbreach.jetpackcomposesamples.ui.listAnimations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developersbreach.jetpackcomposesamples.ui.ItemListAnimations
import com.developersbreach.jetpackcomposesamples.ui.common.CategoryAppBar
import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme

@ExperimentalAnimationApi
@Composable
fun ListAnimations(
    selectedAnimationCategory: (Int) -> Unit,
    navigateUp: () -> Unit
) {

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                CategoryAppBar(
                    navigateUp = navigateUp,
                    title = "Item List Animations"
                )
            }
        ) {
            ItemAnimationCategories(selectedAnimationCategory)
        }
    }
}

@Composable
fun ItemAnimationCategories(
    selectedAnimationCategory: (Int) -> Unit
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
        items(ItemListAnimations.itemsAnimationsData) { animationCategory ->
            ItemAnimation(animationCategory, selectedAnimationCategory)
        }
    }
}

@Composable
fun ItemAnimation(
    animationCategory: ItemListAnimations,
    selectedAnimationCategory: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.surface)
            .clickable {
                selectedAnimationCategory(animationCategory.ItemAnimationId)
            }
    ) {
        Text(
            text = animationCategory.ItemAnimationName,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@ExperimentalAnimationApi
@Preview("AnimationsCategoryPreview", widthDp = 360, heightDp = 640)
@Composable
fun PreviewDarkAnimationsCategoryList() {
    ComposeTheme(darkTheme = true) {
        ListAnimations(selectedAnimationCategory = { }) { }
    }
}
