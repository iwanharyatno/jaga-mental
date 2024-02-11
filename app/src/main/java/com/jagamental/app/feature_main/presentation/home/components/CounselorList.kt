package com.jagamental.app.feature_main.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jagamental.app.feature_main.domain.model.Counselor
import com.jagamental.app.ui.theme.JagaMentalTheme
import kotlin.random.Random

@Composable
fun CounselorList(
    counselors: List<Counselor>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(counselors) { counselor ->
            CounselorItem(
                counselor = counselor,
                onClick = {/*TODO*/}
            )
        }
    }
}

@Preview
@Composable
fun CounselorListPreview() {
    JagaMentalTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            ) {
                CounselorList(
                    listOf(
                        Counselor(
                            id = 1,
                            name = "Random person with cool names",
                            imgUrl = "https://i.pravatar.cc/720",
                            ratings = Random(123).nextDouble(4.0, 5.0)
                        ),
                        Counselor(
                            id = 1,
                            name = "Random person with cool names",
                            imgUrl = "https://i.pravatar.cc/720",
                            ratings = Random(123).nextDouble(4.0, 5.0)
                        )
                    )
                )
            }
        }
    }
}