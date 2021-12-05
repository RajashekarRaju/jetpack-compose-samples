package com.developersbreach.jetpackcomposesamples.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

/**
 * Title with Cards in each categories
 */
@Composable
fun TitleOfTheCategory(
    selectedCategory: (Int) -> Unit,
    categoryId: Int,
    categoryName: String
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.surface)
            .clickable {
                selectedCategory(categoryId)
            }
    ) {
        Text(
            text = categoryName,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(16.dp)
        )
    }
}