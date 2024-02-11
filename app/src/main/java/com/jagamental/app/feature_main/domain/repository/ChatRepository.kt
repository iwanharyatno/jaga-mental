package com.jagamental.app.feature_main.domain.repository

import com.jagamental.app.feature_main.domain.model.Chat
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun getChats() : Flow<List<Chat>>
}