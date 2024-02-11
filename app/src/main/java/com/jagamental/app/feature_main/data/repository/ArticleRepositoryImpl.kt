package com.jagamental.app.feature_main.data.repository

import com.jagamental.app.feature_main.domain.model.Article
import com.jagamental.app.feature_main.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ArticleRepositoryImpl : ArticleRepository {
    override fun getArticles(): Flow<List<Article>> {
        return flowOf(
            listOf(
                Article(
                    title = "Pentingnya Menjaga Kesehatan Mental",
                    imageUrl = "https://placehold.co/1920x1080.png"
                ),
                Article(
                    title = "Pentingnya Menjaga Kesehatan Mental",
                    imageUrl = "https://placehold.co/1920x1080.png"
                ),
                Article(
                    title = "Pentingnya Menjaga Kesehatan Mental",
                    imageUrl = "https://placehold.co/1920x1080.png"
                ),
                Article(
                    title = "Pentingnya Menjaga Kesehatan Mental",
                    imageUrl = "https://placehold.co/1920x1080.png"
                )
            )
        )
    }
}