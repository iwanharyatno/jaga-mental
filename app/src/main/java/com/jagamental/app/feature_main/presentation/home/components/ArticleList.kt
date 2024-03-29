package com.jagamental.app.feature_main.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jagamental.app.feature_main.domain.model.Article
import com.jagamental.app.feature_main.presentation.components.ArticleItem

@Composable
fun ArticleList(
    articles: List<Article>,
    onItemClick: (Article) -> Unit,
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(articles) { article ->
            ArticleItem(
                article = article,
                onClick = { onItemClick(article) },
                modifier = Modifier.width(240.dp)
            )
        }
    }
}