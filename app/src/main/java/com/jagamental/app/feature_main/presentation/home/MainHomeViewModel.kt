package com.jagamental.app.feature_main.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagamental.app.feature_main.domain.model.Filter
import com.jagamental.app.feature_main.domain.repository.ArticleRepository
import com.jagamental.app.feature_main.domain.repository.ChatRepository
import com.jagamental.app.feature_main.domain.repository.CommunityRepository
import com.jagamental.app.feature_main.domain.repository.CounselorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainHomeViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
    private val counselorRepository: CounselorRepository,
    private val communityRepository: CommunityRepository,
) : ViewModel() {
    private val _uiState = mutableStateOf(MainHomeState())
    val uiState: State<MainHomeState> = _uiState

    private var getArticlesJob: Job? = null
    private var getCounselorsJob: Job? = null
    private var getCommunitiesJob: Job? = null

    init {
        getArticles()
        getCounselors()
        getCommunities()
    }

    fun onEvent(event: MainHomeEvent) {
        when (event) {
            is MainHomeEvent.ChangeSearchQuery -> {
                _uiState.value = uiState.value.copy(
                    searchQuery = event.value
                )
            }
            is MainHomeEvent.ChangeCounselorFilter -> {
                _uiState.value = uiState.value.copy(
                    currentCounselorFilter = event.value
                )
                getCounselors()
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

    private fun getCounselors() {
        getCounselorsJob?.cancel()
        getCounselorsJob = counselorRepository.getCounselors(uiState.value.currentCounselorFilter).onEach { counselors ->
            _uiState.value = uiState.value.copy(
                counselors = counselors
            )
        }.launchIn(viewModelScope)
    }

    private fun getCommunities() {
        getCommunitiesJob?.cancel()
        getCommunitiesJob = communityRepository.getCommunities().onEach { communities ->
            _uiState.value = uiState.value.copy(
                communities = communities
            )
        }.launchIn(viewModelScope)
    }
}