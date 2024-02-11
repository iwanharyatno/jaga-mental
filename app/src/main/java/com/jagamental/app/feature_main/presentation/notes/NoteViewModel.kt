package com.jagamental.app.feature_main.presentation.notes

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagamental.app.feature_main.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@Suppress("OPT_IN_USAGE_FUTURE_ERROR")
@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    private val _uiState = mutableStateOf(NoteState())
    val uiState : State<NoteState> = _uiState

    private var getNotesJob: Job? = null

    init {
        getNotes()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    private fun getNotes() {
        Log.d(this::class.simpleName, uiState.value.datePickerState.selectedDateMillis.toString())
        getNotesJob?.cancel()
        getNotesJob = noteRepository.getNotes(uiState.value.datePickerState.selectedDateMillis).onEach { notes ->
            _uiState.value = uiState.value.copy(
                notes = notes
            )
        }.launchIn(viewModelScope)
    }
}