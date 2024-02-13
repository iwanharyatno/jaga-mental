package com.jagamental.app.feature_main.presentation.articles

import com.jagamental.app.feature_main.domain.model.Article

data class ArticleState(
    val articles: List<Article> = emptyList(),
    val searchQuery: String = String()
)