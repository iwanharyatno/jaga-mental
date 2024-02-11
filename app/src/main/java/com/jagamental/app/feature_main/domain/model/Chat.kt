package com.jagamental.app.feature_main.domain.model

data class Chat(
    val id: Int,
    val title: String,
    val imgUrl: String,
    val messages: List<Message> = listOf(),
)