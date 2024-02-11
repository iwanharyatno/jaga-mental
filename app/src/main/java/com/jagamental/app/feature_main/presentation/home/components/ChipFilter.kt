package com.jagamental.app.feature_main.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jagamental.app.feature_main.domain.model.Filter
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun ChipFilter(
    filter: Filter,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .border(
                width = Dp.Hairline,
                color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(50)
            )
            .clip(shape = RoundedCornerShape(50))
            .clickable { onClick() }
            .background(color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background)
            .padding(vertical = 8.dp, horizontal = 18.dp)
    ) {
        Text(
            text = filter.displayName,
            color = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview
@Composable
fun ChipFilterPreview() {
    JagaMentalTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            ChipFilter(
                filter = Filter("semua", "Semua"),
                selected = false,
                onClick = {}
            )
            ChipFilter(
                filter = Filter("semua", "Semua"),
                selected = true,
                onClick = {}
            )
        }
    }
}