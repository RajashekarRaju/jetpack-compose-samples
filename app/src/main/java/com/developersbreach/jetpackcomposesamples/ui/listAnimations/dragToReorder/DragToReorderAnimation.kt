package com.developersbreach.jetpackcomposesamples.ui.listAnimations.dragToReorder

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.developersbreach.jetpackcomposesamples.R
import com.developersbreach.jetpackcomposesamples.ui.common.CategoryAppBar
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.model.ShoesArticle
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.model.ShoesArticle.Companion.allShoesArticles
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.model.SlideState


@ExperimentalAnimationApi
@Composable
fun DragToReorderAnimation(
    navigateUp: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                CategoryAppBar(
                    navigateUp = navigateUp,
                    title = "Drag to Reorder"
                )
            }
        ) {
            DragToReorder()
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun DragToReorder() {

    val shoesArticles = remember { mutableStateListOf(*allShoesArticles) }

    val slideStates = remember {
        mutableStateMapOf<ShoesArticle, SlideState>()
            .apply {
                shoesArticles.map { shoesArticle ->
                    shoesArticle to SlideState.NONE
                }.toMap().also {
                    putAll(it)
                }
            }
    }

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
            slideStates = slideStates,
            updateSlideState = { shoesArticle, slideState ->
                slideStates[shoesArticle] = slideState
            },
            updateItemPosition = { currentIndex, destinationIndex ->
                val shoesArticle = shoesArticles[currentIndex]
                shoesArticles.removeAt(currentIndex)
                shoesArticles.add(destinationIndex, shoesArticle)
                slideStates.apply {
                    shoesArticles.map { shoesArticle ->
                        shoesArticle to SlideState.NONE
                    }.toMap().also {
                        putAll(it)
                    }
                }
            }
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun ShoesList(
    modifier: Modifier,
    shoesArticles: MutableList<ShoesArticle>,
    slideStates: Map<ShoesArticle, SlideState>,
    updateSlideState: (shoesArticle: ShoesArticle, slideState: SlideState) -> Unit,
    updateItemPosition: (currentIndex: Int, destinationIndex: Int) -> Unit
) {

    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState,
        modifier = modifier.padding(top = dimensionResource(id = R.dimen.list_top_padding))
    ) {
        items(shoesArticles.size) { index ->

            val shoesArticle = shoesArticles.getOrNull(index)

            if (shoesArticle != null) {
                key(shoesArticle) {
                    val slideState = slideStates[shoesArticle] ?: SlideState.NONE
                    ShoesCard(
                        shoesArticle = shoesArticle,
                        slideState = slideState,
                        shoesArticles = shoesArticles,
                        updateSlideState = updateSlideState,
                        updateItemPosition = updateItemPosition
                    )
                }
            }
        }
    }
}