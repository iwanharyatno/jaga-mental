package com.jagamental.app.feature_main.presentation.chat

sealed class ChatEvent {
    data class ChangeSearchQuery(val value: String) : ChatEvent()
}