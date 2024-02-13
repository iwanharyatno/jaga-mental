package com.jagamental.app.feature_main.presentation.article_detail

sealed class ArticleDetailEvent {
    data class ChangeSearchQuery(val value: String) : ArticleDetailEvent()
}