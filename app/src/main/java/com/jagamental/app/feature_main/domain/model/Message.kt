package com.jagamental.app.feature_main.domain.model

import java.util.Calendar

data class Message(
    val id: Int,
    val text: String,
    val time: Calendar = Calendar.getInstance(),
)
