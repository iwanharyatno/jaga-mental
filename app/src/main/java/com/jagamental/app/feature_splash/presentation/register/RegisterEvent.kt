package com.jagamental.app.feature_splash.presentation.register

sealed class RegisterEvent {
    data class ChangeUsername(val value: String) : RegisterEvent()
    data class ChangeEmail(val value: String) : RegisterEvent()
    data class ChangePassword(val value: String) : RegisterEvent()
    data class ChangeConfirmPassword(val value: String) : RegisterEvent()
    data class ChangePhoneNumber(val value: String) : RegisterEvent()
    data class ChangePasswordVisibility(val value: Boolean) : RegisterEvent()
    data class ChangeConfirmPasswordVisibility(val value: Boolean) : RegisterEvent()
    object RegisterUser : RegisterEvent()
}