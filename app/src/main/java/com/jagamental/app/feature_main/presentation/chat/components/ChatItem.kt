package com.jagamental.app.feature_main.presentation.chat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jagamental.app.feature_main.domain.model.Chat
import com.jagamental.app.feature_main.domain.model.Message
import com.jagamental.app.ui.theme.JagaMentalTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun ChatItem(
    chat: Chat,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AsyncImage(
            model = chat.imgUrl,
            contentDescription = chat.title,
            modifier = Modifier
                .size(56.dp)
                .clip(shape = RoundedCornerShape(50))
                .background(color = Color.LightGray)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = chat.title,
                fontWeight = FontWeight.Bold
            )
            Text(text = chat.messages.last().text)
        }
        Text(text = SimpleDateFormat("HH:mm", Locale.getDefault()).format(chat.messages.last().time.time))
    }
}

@Preview
@Composable
fun ChatItemPreview() {
    JagaMentalTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ChatItem(
                    Chat(
                        id = 1,
                        title = "Komunitas Save Healthy",
                        imgUrl = "https://i.pravatar.cc/100",
                        messages = listOf(
                            Message(
                                id = 1,
                                text = "Hello Bro awkakakwkwk"
                            )
                        )
                    )
                ) {}
            }
        }
    }
}