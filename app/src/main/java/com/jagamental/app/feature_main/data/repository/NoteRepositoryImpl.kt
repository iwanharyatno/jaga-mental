package com.jagamental.app.feature_main.data.repository

import com.jagamental.app.feature_main.domain.model.Note
import com.jagamental.app.feature_main.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.Calendar

class NoteRepositoryImpl : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return flowOf(
            listOf(
                Note(
                    id = 1,
                    title = "Judul Catatan Hari Ini"
                ),
                Note(
                    id = 2,
                    title = "Judul Catatan Hari Ini"
                ),
                Note(
                    id = 3,
                    title = "Judul Catatan Hari Ini"
                ),
                Note(
                    id = 4,
                    title = "Judul Catatan Hari Ini"
                ),
            )
        )
    }

    override fun getNotes(selectedDateMillis: Long?): Flow<List<Note>> {
        val dateMillis = selectedDateMillis ?: Calendar.getInstance().timeInMillis

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = dateMillis

        return flowOf(
            listOf(
                Note(
                    id = 1,
                    title = "Judul Catatan Hari Ini",
                    date = calendar,
                ),
                Note(
                    id = 2,
                    title = "Judul Catatan Hari Ini",
                    date = calendar,
                ),
                Note(
                    id = 3,
                    title = "Judul Catatan Hari Ini",
                    date = calendar,
                ),
                Note(
                    id = 4,
                    title = "Judul Catatan Hari Ini",
                    date = calendar,
                ),
            )
        )
    }
}