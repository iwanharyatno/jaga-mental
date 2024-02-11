package com.jagamental.app.feature_main.presentation.notes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jagamental.app.feature_main.domain.model.Note
import com.jagamental.app.feature_main.presentation.notes.components.NewNoteButton
import com.jagamental.app.feature_main.presentation.notes.components.NotesList
import com.jagamental.app.ui.theme.JagaMentalTheme
import java.util.Calendar

@Composable
fun NoteScreen(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
    viewModel: NoteViewModel = hiltViewModel()
) {
    NoteScreenPure(
        navController = navController,
        tabController = tabController,
        snackbarHostState = snackbarHostState,
        state = viewModel.uiState.value
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreenPure(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
    state: NoteState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Catatan Harian",
                fontWeight = FontWeight.Bold
            )
        }
        DatePicker(
            state = state.datePickerState
        )
        Spacer(modifier = Modifier.height(8.dp))
        NewNoteButton(
            onClick = {}
        )
        Spacer(modifier = Modifier.height(8.dp))
        NotesList (
            notes = state.notes,
            modifier = Modifier.weight(1f)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NoteScreenPreview() {
    JagaMentalTheme {
        Surface {
            NoteScreenPure(
                navController = rememberNavController(),
                tabController = rememberNavController(),
                snackbarHostState = SnackbarHostState(),
                state = NoteState(
                    notes = listOf(
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
                    ),
                    datePickerState = rememberDatePickerState()
                )
            )
        }
    }
}