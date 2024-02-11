package com.jagamental.app.feature_main.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jagamental.app.feature_main.domain.model.Filter
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun ChipFilterBand(
    filters: List<Filter>,
    selected: Filter,
    onChange: (Filter) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        items(filters) { filter ->
            ChipFilter(
                filter = filter,
                selected = filter.name == selected.name,
                onClick = { onChange(filter) }
            )
        }
    }
}

@Preview
@Composable
fun ChipFilterBandPreview() {
    JagaMentalTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ChipFilterBand(
                    filters = listOf(
                        Filter("semua", "Semua"),
                        Filter("gratis", "Gratis"),
                        Filter("pria", "Pria"),
                        Filter("wanita", "Wanita"),
                    ),
                    selected = Filter("gratis", "Semua"),
                    onChange = {}
                )
            }
        }
    }
}