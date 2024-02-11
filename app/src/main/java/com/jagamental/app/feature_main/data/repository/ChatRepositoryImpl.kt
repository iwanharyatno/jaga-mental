package com.jagamental.app.feature_main.data.repository

import com.jagamental.app.feature_main.domain.model.Chat
import com.jagamental.app.feature_main.domain.model.Message
import com.jagamental.app.feature_main.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ChatRepositoryImpl : ChatRepository {
    override fun getChats(): Flow<List<Chat>> {
        return flowOf(
            listOf(
                Chat(
                    id = 1,
                    title = "Komunitas Save Healthy",
                    imgUrl = "https://i.pravatar.cc/100?t=c1",
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
                    imgUrl = "https://i.pravatar.cc/100?t=c2",
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
                    imgUrl = "https://i.pravatar.cc/100?t=c3",
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
                    imgUrl = "https://i.pravatar.cc/100?t=c4",
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
                    imgUrl = "https://i.pravatar.cc/100?t=c5",
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
                    imgUrl = "https://i.pravatar.cc/100?t=c6",
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
                    imgUrl = "https://i.pravatar.cc/100?t=c7",
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