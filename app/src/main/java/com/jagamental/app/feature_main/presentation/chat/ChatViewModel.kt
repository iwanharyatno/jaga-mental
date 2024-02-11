package com.jagamental.app.feature_main.presentation.chat

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagamental.app.feature_main.domain.repository.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor (
    private val chatRepository: ChatRepository
): ViewModel() {
    private val _uiState = mutableStateOf(ChatState())
    val uiState: State<ChatState> = _uiState

    private var getChatsJob: Job? = null

    init {
        getChats()
    }

    fun onEvent(event: ChatEvent) {
        when(event) {
            is ChatEvent.ChangeSearchQuery -> {
                _uiState.value = uiState.value.copy(
                    searchQuery = event.value
                )
            }
        }
    }

    private fun getChats() {
        getChatsJob?.cancel()
        getChatsJob = chatRepository.getChats().onEach { chats ->
            _uiState.value = uiState.value.copy(
                chats = chats
            )
        }.launchIn(viewModelScope)
    }
}