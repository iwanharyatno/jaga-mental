package com.jagamental.app.feature_main.presentation.article_detail

import com.jagamental.app.feature_main.domain.model.Article

data class ArticleDetailState(
    val article: Article = Article(1, "Just Any Title")
)