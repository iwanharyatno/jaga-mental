package com.jagamental.app.feature_main.presentation.notes

import com.jagamental.app.feature_main.domain.model.Note

data class NoteState (
    val notes: List<Note> = emptyList(),
)