package com.jagamental.app.feature_main.presentation.notes

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import com.jagamental.app.feature_main.domain.model.Note

data class NoteState @OptIn(ExperimentalMaterial3Api::class) constructor(
    val notes: List<Note> = emptyList(),
    val datePickerState: DatePickerState = DatePickerState(null, null, IntRange(2020, 2024), DisplayMode.Input)
)
