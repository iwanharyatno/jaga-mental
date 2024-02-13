package com.jagamental.app.feature_main.presentation.articles.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jagamental.app.feature_main.domain.model.Article
import com.jagamental.app.feature_main.presentation.components.ArticleItem

@Composable
fun ArticleList(
    articles: List<Article>,
    modifier: Modifier = Modifier,
    onItemClick: (Article) -> Unit,
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(articles) { article ->
            ArticleItem(
                article = article,
                onClick = { onItemClick(article) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
