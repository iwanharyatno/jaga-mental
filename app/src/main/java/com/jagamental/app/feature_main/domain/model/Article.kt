package com.jagamental.app.feature_main.domain.model

data class Article(
    val id: Int,
    val title: String,
    val imageUrl: String? = null,
    val content: String = String(),
)