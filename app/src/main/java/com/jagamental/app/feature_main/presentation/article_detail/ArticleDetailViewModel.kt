package com.jagamental.app.feature_main.presentation.article_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagamental.app.feature_main.domain.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = mutableStateOf(ArticleDetailState())
    val uiState: State<ArticleDetailState> = _uiState

    init {
        savedStateHandle.get<Int>("articleId")?.let { articleId ->
            if (articleId != -1) {
                viewModelScope.launch {
                    articleRepository.getArticle(articleId).also {
                        _uiState.value = uiState.value.copy(
                            article = it
                        )
                    }
                }
            }
        }
    }
}