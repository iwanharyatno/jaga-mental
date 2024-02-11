package com.jagamental.app.feature_splash.presentation.login

sealed class LoginEvent {
    data class ChangeUsername(val value: String) : LoginEvent()
    data class ChangePassword(val value: String) : LoginEvent()
    data class ChangePasswordVisible(val value: Boolean) : LoginEvent()
    object LoginUser : LoginEvent()
}
