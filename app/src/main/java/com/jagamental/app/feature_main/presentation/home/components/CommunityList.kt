package com.jagamental.app.feature_main.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jagamental.app.feature_main.domain.model.Community
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun CommunityList(
    communities: List<Community>
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(communities) { community ->
            CommunityItem(
                community = community,
                onClick = {/*TODO*/}
            )
        }
    }
}

@Preview
@Composable
fun CommunityListPreview() {
    JagaMentalTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                CommunityList(
                    listOf(
                        Community(
                            id = 1,
                            name = "Random Community",
                            imageUrl = "https://placehold.co/400x600.png"
                        ),
                        Community(
                            id = 2,
                            name = "Random Community",
                            imageUrl = "https://placehold.co/400x600.png"
                        ),
                        Community(
                            id = 3,
                            name = "Random Community",
                            imageUrl = "https://placehold.co/400x600.png"
                        ),
                        Community(
                            id = 4,
                            name = "Random Community",
                            imageUrl = "https://placehold.co/400x600.png"
                        ),
                        Community(
                            id = 5,
                            name = "Random Community",
                            imageUrl = "https://placehold.co/400x600.png"
                        ),
                        Community(
                            id = 6,
                            name = "Random Community",
                            imageUrl = "https://placehold.co/400x600.png"
                        ),
                        Community(
                            id = 7,
                            name = "Random Community",
                            imageUrl = "https://placehold.co/400x600.png"
                        ),
                        Community(
                            id = 8,
                            name = "Random Community",
                            imageUrl = "https://placehold.co/400x600.png"
                        ),
                    )
                )
            }
        }
    }
}