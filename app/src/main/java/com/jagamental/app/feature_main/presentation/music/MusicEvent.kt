package com.jagamental.app.feature_main.presentation.music

sealed class MusicEvent {
    data class ChangeFavorite(val value: Boolean) : MusicEvent()
}
