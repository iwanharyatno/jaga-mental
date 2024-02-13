package com.jagamental.app.feature_main.presentation.articles

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagamental.app.feature_main.domain.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
) : ViewModel() {
    private val _uiState = mutableStateOf(ArticleState())
    val uiState: State<ArticleState> = _uiState

    private var getArticlesJob: Job? = null

    init {
        getArticles()
    }

    fun onEvent(event: ArticleEvent) {
        when (event) {
            is ArticleEvent.ChangeSearchQuery -> {
                _uiState.value = uiState.value.copy(
                    searchQuery = event.value
                )
            }
        }
    }

    private fun getArticles() {
        getArticlesJob?.cancel()
        getArticlesJob = articleRepository.getArticles().onEach { articles ->
            _uiState.value = uiState.value.copy(
                articles = articles
            )
        }.launchIn(viewModelScope)
    }
}