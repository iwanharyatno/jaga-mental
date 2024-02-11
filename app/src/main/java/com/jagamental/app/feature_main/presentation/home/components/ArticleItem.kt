package com.jagamental.app.feature_main.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jagamental.app.feature_main.domain.model.Article

@Composable
fun ArticleItem(
    article: Article,
    onClick: () -> Unit
) {
    AsyncImage(
        model = article.imageUrl,
        contentDescription = article.title,
        modifier = Modifier
            .width(240.dp)
            .clip(shape = RoundedCornerShape(18.dp))
            .aspectRatio(16f / 9)
            .background(color = Color.LightGray)
            .clickable { onClick() },
        contentScale = ContentScale.FillBounds
    )
}