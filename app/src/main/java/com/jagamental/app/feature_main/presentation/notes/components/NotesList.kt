package com.jagamental.app.feature_main.presentation.notes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jagamental.app.feature_main.domain.model.Note
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun NotesList(
    notes: List<Note>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(notes) { note ->
            NotesItem(note = note)
        }
    }
}

@Preview
@Composable
fun NotesListPreview() {
    JagaMentalTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(18.dp)
            ) {
                NotesList(notes = listOf(
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
                ))
            }
        }
    }
}