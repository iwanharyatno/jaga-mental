package com.jagamental.app.feature_main.presentation.chat.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jagamental.app.feature_main.domain.model.Chat
import com.jagamental.app.feature_main.domain.model.Message
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun ChatList(
    chats: List<Chat>
) {
    LazyColumn {
        items(chats) { chat ->
            ChatItem(
                chat = chat,
                onClick = {}
            )
            Divider()
        }
    }
}

@Preview
@Composable
fun ChatListPreview() {
    JagaMentalTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ChatList(
                    listOf(
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
                        ),
                        Chat(
                            id = 2,
                            title = "Komunitas Save Healthy",
                            imgUrl = "https://i.pravatar.cc/100",
                            messages = listOf(
                                Message(
                                    id = 1,
                                    text = "Hello Bro awkakakwkwk"
                                )
                            )
                        ),
                        Chat(
                            id = 3,
                            title = "Komunitas Save Healthy",
                            imgUrl = "https://i.pravatar.cc/100",
                            messages = listOf(
                                Message(
                                    id = 1,
                                    text = "Hello Bro awkakakwkwk"
                                )
                            )
                        ),
                        Chat(
                            id = 4,
                            title = "Komunitas Save Healthy",
                            imgUrl = "https://i.pravatar.cc/100",
                            messages = listOf(
                                Message(
                                    id = 1,
                                    text = "Hello Bro awkakakwkwk"
                                )
                            )
                        ),
                        Chat(
                            id = 5,
                            title = "Komunitas Save Healthy",
                            imgUrl = "https://i.pravatar.cc/100",
                            messages = listOf(
                                Message(
                                    id = 1,
                                    text = "Hello Bro awkakakwkwk"
                                )
                            )
                        ),
                        Chat(
                            id = 6,
                            title = "Komunitas Save Healthy",
                            imgUrl = "https://i.pravatar.cc/100",
                            messages = listOf(
                                Message(
                                    id = 1,
                                    text = "Hello Bro awkakakwkwk"
                                )
                            )
                        ),
                        Chat(
                            id = 7,
                            title = "Komunitas Save Healthy",
                            imgUrl = "https://i.pravatar.cc/100",
                            messages = listOf(
                                Message(
                                    id = 1,
                                    text = "Hello Bro awkakakwkwk"
                                )
                            )
                        ),
                    )
                )
            }
        }
    }
}