package com.jagamental.app.feature_main.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jagamental.app.feature_main.domain.model.Community
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun CommunityItem(
    community: Community,
    onClick: () -> Unit
) {
    AsyncImage(
        model = community.imageUrl,
        contentDescription = community.name,
        modifier = Modifier
            .width(80.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .aspectRatio(400f / 600)
            .background(color = Color.LightGray)
            .clickable { onClick() },
        contentScale = ContentScale.FillBounds
    )
}

@Preview
@Composable
fun CommunityItemPreview() {
    JagaMentalTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                CommunityItem(
                    community = Community(1, "Name", "https://placehold.co/400x600.png"),
                    onClick = {}
                )
            }
        }
    }
}