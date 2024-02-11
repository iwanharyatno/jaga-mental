package com.jagamental.app.feature_main.presentation.music

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = mutableStateOf(MusicState())
    val uiState: State<MusicState> = _uiState

    fun onEvent(event: MusicEvent) {
        when(event) {
            is MusicEvent.ChangeFavorite -> {
                _uiState.value = uiState.value.copy(
                    favorite = event.value
                )
            }
        }
    }
}