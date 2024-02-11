package com.jagamental.app.feature_main.domain.model

data class Counselor(
    val id: Int,
    val name: String,
    val imgUrl: String,
    val ratings: Double,
    val isPro: Boolean = false,
)
