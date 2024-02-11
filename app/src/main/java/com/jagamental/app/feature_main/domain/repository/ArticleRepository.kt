package com.jagamental.app.feature_main.domain.repository

import com.jagamental.app.feature_main.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles() : Flow<List<Article>>
}