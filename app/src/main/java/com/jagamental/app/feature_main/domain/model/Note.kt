package com.jagamental.app.feature_main.domain.model

import java.util.Calendar

data class Note(
    val id: Int,
    val title: String,
    val content: String = String(),
    val date: Calendar = Calendar.getInstance()
)
