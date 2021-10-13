package com.developersbreach.jetpackcomposesamples.ui.listAnimations.addItemToList

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.developersbreach.jetpackcomposesamples.R
import com.developersbreach.jetpackcomposesamples.ui.common.CategoryAppBar
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.model.ShoesArticle
import com.developersbreach.jetpackcomposesamples.ui.listAnimations.model.ShoesArticle.Companion.allShoesArticles
import com.developersbreach.jetpackcomposesamples.ui.theme.*


@ExperimentalAnimationApi
@Composable
fun AddItemToListAnimation(
    navigateUp: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                CategoryAppBar(
                    navigateUp = navigateUp,
                    title = "Add Item to List"
                )
            }
        ) {
            AddItemToList()
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun AddItemToList() {

    val colorsArray = arrayOf(Purple, Blue, Red)
    var isFired by remember { mutableStateOf(false) }
    var particleColor by remember { mutableStateOf(Color.White) }
    val shoesArticles = remember { mutableStateListOf<ShoesArticle>() }

    val isVisibleStates = remember {
        mutableStateMapOf<ShoesArticle, Boolean>()
            .apply {
                shoesArticles.map { shoesArticle ->
                    shoesArticle to false
                }.toMap().also {
                    putAll(it)
                }
            }
    }

    var addedArticle by remember { mutableStateOf(ShoesArticle()) }
    var id by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            Box {
                Particle(
                    modifier = Modifier
                        .align(Alignment.BottomCenter),
                    isFired = isFired,
                    color = particleColor,
                    onCompleteAnim = {
                        isVisibleStates[addedArticle] = true
                        isFired = false
                    }
                )
                TopAppBar(
                    title = {
                        Text(text = "List Animations In Compose")
                    },
                    actions = {
                        IconButton(onClick = {
                            particleColor = colorsArray.random()
                            addedArticle =
                                allShoesArticles.first { it.color == particleColor }.copy(id = id)
                                    .also {
                                        id++
                                    }
                            shoesArticles.add(0, addedArticle)
                            isFired = true
                        }) {
                            Icon(Icons.Filled.AddCircle, contentDescription = null)
                        }
                    },
                    backgroundColor = MaterialTheme.colors.background
                )
            }
        }
    ) { innerPadding ->
        ShoesList(
            modifier = Modifier.padding(innerPadding),
            isVisibleStates = isVisibleStates,
            shoesArticles = shoesArticles
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun ShoesList(
    modifier: Modifier,
    isVisibleStates: Map<ShoesArticle, Boolean>,
    shoesArticles: MutableList<ShoesArticle>
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
                    ShoesCard(
                        shoesArticle = shoesArticle,
                        isVisible = isVisibleStates[shoesArticle] == true
                    )
                }
            }
        }
    }
}
