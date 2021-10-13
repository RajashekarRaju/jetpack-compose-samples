package com.developersbreach.jetpackcomposesamples.ui.listAnimations.model

import androidx.compose.ui.graphics.Color
import com.developersbreach.jetpackcomposesamples.R
import com.developersbreach.jetpackcomposesamples.ui.theme.*

data class ShoesArticle(
    var id: Int = 0,
    var title: String = "",
    var price: Float = 0f,
    var width: String = "",
    var drawable: Int = 0,
    var color: Color = Color.Transparent
) {

    companion object {

        val allShoesArticles = arrayOf(
            ShoesArticle(
                title = "Nike Air Max 270",
                price = 199.8f,
                width = "2X Wide",
                drawable = R.drawable.ic_shoes_1,
                color = Red
            ),
            ShoesArticle(
                title = "Nike Joyride Run V",
                price = 249.1f,
                width = "3X Wide",
                drawable = R.drawable.ic_shoes_2,
                color = Blue
            ),
            ShoesArticle(
                title = "Nike Space Hippie 04",
                price = 179.7f,
                width = "Extra Wide",
                drawable = R.drawable.ic_shoes_3,
                color = Purple
            )
        )
    }
}