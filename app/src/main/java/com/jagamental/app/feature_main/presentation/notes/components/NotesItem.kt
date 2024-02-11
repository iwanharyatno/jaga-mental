package com.jagamental.app.feature_main.presentation.notes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jagamental.app.feature_main.domain.model.Note
import com.jagamental.app.ui.theme.JagaMentalTheme
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun NotesItem(
    note: Note
) {
    Row(
        modifier = Modifier
            .border(
                width = Dp.Hairline,
                color = MaterialTheme.colorScheme.secondary,
                shape = MaterialTheme.shapes.small
            )
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.background)
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(50))
                .background(color = MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = note.title,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(note.date.time),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview
@Composable
fun NotesItemPreview() {
    JagaMentalTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(18.dp)
            ) {
                NotesItem(note = Note(1, "Hari yang baik", ""))
            }
        }
    }
}