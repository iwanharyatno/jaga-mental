package com.jagamental.app.feature_main.presentation.report.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jagamental.app.R
import com.jagamental.app.ui.theme.JagaMentalTheme
import com.jagamental.app.ui.theme.YellowBullying

@Composable
fun ReportCard(
    title: String,
    cover: Painter,
    modifier: Modifier = Modifier,
    smallTitle: String = String(),
    onClick: () -> Unit,
    color: Color = LocalContentColor.current
) {
    Box(
        modifier = modifier
            .fillMaxWidth(0.5f)
            .aspectRatio(1f)
            .shadow(
                shape = MaterialTheme.shapes.medium,
                elevation = 8.dp
            )
            .clickable { onClick() },
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = cover,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = smallTitle,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = color
                )
            )
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = color
                )
            )
        }
    }
}

@Preview
@Composable
fun ReportCardPreview() {
    JagaMentalTheme {
        Surface {
            Column (
                modifier = Modifier.fillMaxSize()
                    .padding(18.dp)
            ) {
                ReportCard(
                    title = "Bullying",
                    smallTitle = "Kasus",
                    cover = painterResource(id = R.mipmap.bullying_report),
                    onClick = {},
                    color = YellowBullying
                )
            }
        }
    }
}