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
                    id = 1,
                    title = "Pentingnya Menjaga Kesehatan Mental",
                    imageUrl = "https://placehold.co/1920x1080.png"
                ),
                Article(
                    id = 2,
                    title = "Pentingnya Menjaga Kesehatan Mental",
                    imageUrl = "https://placehold.co/1920x1080.png"
                ),
                Article(
                    id = 3,
                    title = "Pentingnya Menjaga Kesehatan Mental",
                    imageUrl = "https://placehold.co/1920x1080.png"
                ),
                Article(
                    id = 4,
                    title = "Pentingnya Menjaga Kesehatan Mental",
                    imageUrl = "https://placehold.co/1920x1080.png"
                )
            )
        )
    }

    override fun getArticle(id: Int): Article {
        return Article(
            id = id,
            title = "Pentingnya Menjaga Kesehatan Mental",
            imageUrl = "https://placehold.co/1920x1080.png",
            content = """
                $id Kesehatan mental merupakan komponen kesehatan yang tak kalah pentingnya dibandingkan dengan kesehatan fisik. Menjaga kesehatan mental menjadi landasan utama untuk mencapai kesejahteraan holistik dan kualitas hidup yang optimal. Semakin dikenalnya pentingnya aspek ini mengingatkan kita pada perlunya perhatian serius terhadap kesehatan mental sebagai bagian integral dari kehidupan sehari-hari.

                Adanya tekanan  hidup modern seringkali dapat memberikan dampak negatif pada kesehatan mental seseorang. menjaga kesehatan mental menjadi langkah pertama dalam mengatasi stres dan tantangan hidup. Kesehatan mental yang baik tidak hanya melibatkan ketiadaan gangguan mental, tetapi juga mencakup kemampuan untuk mengelola emosi, menjaga hubungan yang sehat, dan memiliki kekuatan mental yang adaptif.
            """.trimIndent()
        )
    }
}