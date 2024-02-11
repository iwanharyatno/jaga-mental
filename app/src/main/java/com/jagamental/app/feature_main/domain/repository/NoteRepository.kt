package com.jagamental.app.feature_main.domain.repository

import com.jagamental.app.feature_main.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes() : Flow<List<Note>>
    fun getNotes(selectedDateMillis: Long?) : Flow<List<Note>>
}