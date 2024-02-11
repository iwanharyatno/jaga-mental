package com.jagamental.app.feature_main.presentation.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun SectionHeader(
    title: String,
    onAllClick: () -> Unit,
    modifier: Modifier = Modifier,
    allText: String = "All"
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        val annotatedString = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.secondary)) {
                pushStringAnnotation(allText, allText)
                append(allText)
            }
        }
        ClickableText(text = annotatedString, onClick = {
            annotatedString.getStringAnnotations(it, it)
                .firstOrNull()?.let { span ->
                    if (span.item == allText) {
                        onAllClick()
                    }
                }
        })
    }
}

@Preview
@Composable
fun SectionHeaderPreview() {
    JagaMentalTheme {
        Surface {
            SectionHeader(title = "Berita Terbaru", onAllClick = { /*TODO*/ })
        }
    }
}