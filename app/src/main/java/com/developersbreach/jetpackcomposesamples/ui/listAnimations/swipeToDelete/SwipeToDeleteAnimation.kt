package com.developersbreach.jetpackcomposesamples.ui.listAnimations.swipeToDelete

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.developersbreach.jetpackcomposesamples.R
import com.developersbreach.jetpackcomposesamples.ui.common.CategoryAppBar
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.model.ShoesArticle
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.model.ShoesArticle.Companion.allShoesArticles


@ExperimentalAnimationApi
@Composable
fun SwipeToDeleteAnimation(
    navigateUp: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                CategoryAppBar(
                    navigateUp = navigateUp,
                    title = "Swipe to Delete"
                )
            }
        ) {
            SwipeToDelete()
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun SwipeToDelete() {

    val shoesArticles = remember { mutableStateListOf(*allShoesArticles) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "List Animations In Compose")
                },
                actions = {
                    IconButton(onClick = { shoesArticles.addAll(allShoesArticles) }) {
                        Icon(Icons.Filled.AddCircle, contentDescription = null)
                    }
                },
                backgroundColor = MaterialTheme.colors.background
            )
        }
    ) { innerPadding ->
        ShoesList(
            modifier = Modifier.padding(innerPadding),
            shoesArticles = shoesArticles,
            onDelete = { shoesArticles.remove(it) }
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun ShoesList(
    modifier: Modifier,
    shoesArticles: MutableList<ShoesArticle>,
    onDelete: (shoesArticle: ShoesArticle) -> Unit
) {
    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState,
        modifier = modifier.padding(
            top = dimensionResource(id = R.dimen.list_top_padding)
        )
    ) {
        items(shoesArticles.size) { index ->
            val shoesArticle = shoesArticles.getOrNull(index)
            if (shoesArticle != null) {
                key(shoesArticle) {
                    ShoesCard(shoesArticle = shoesArticle) {
                        onDelete(shoesArticle)
                    }
                }
            }
        }
    }
}