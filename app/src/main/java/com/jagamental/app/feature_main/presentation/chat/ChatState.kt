package com.jagamental.app.feature_main.presentation.chat

import com.jagamental.app.feature_main.domain.model.Chat

data class ChatState(
    val chats: List<Chat> = emptyList(),
    val searchQuery: String = String(),
)