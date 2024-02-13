package com.jagamental.app.feature_main.presentation.articles

sealed class ArticleEvent {
    data class ChangeSearchQuery(val value: String) : ArticleEvent()
}