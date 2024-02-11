package com.jagamental.app.feature_splash.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagamental.app.feature_splash.presentation.login.LoginViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
    private val _username = mutableStateOf("")
    val username: State<String> = _username

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _confirmPassword = mutableStateOf("")
    val confirmPassword: State<String> = _confirmPassword

    private val _phoneNumber = mutableStateOf("")
    val phoneNumber: State<String> = _phoneNumber

    private val _passwordVisibility = mutableStateOf(false)
    val passwordVisibility: State<Boolean> = _passwordVisibility

    private val _passwordConfirmationVisibility = mutableStateOf(false)
    val passwordConfirmationVisibility: State<Boolean> = _passwordConfirmationVisibility

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.ChangeUsername -> {
                _username.value = event.value
            }
            is RegisterEvent.ChangeEmail -> {
                _email.value = event.value
            }
            is RegisterEvent.ChangePassword -> {
                _password.value = event.value
            }
            is RegisterEvent.ChangeConfirmPassword -> {
                _confirmPassword.value = event.value
            }
            is RegisterEvent.ChangePhoneNumber -> {
                _phoneNumber.value = event.value
            }
            is RegisterEvent.ChangePasswordVisibility -> {
                _passwordVisibility.value = event.value
            }
            is RegisterEvent.ChangeConfirmPasswordVisibility -> {
                _passwordConfirmationVisibility.value = event.value
            }
            is RegisterEvent.RegisterUser -> {
                viewModelScope.launch {
                    _uiEvent.emit(UiEvent.RegisterUserSuccess)
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String) : UiEvent()
        object RegisterUserSuccess : UiEvent()
    }
}