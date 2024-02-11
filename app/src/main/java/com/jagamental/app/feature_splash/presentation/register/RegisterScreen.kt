package com.jagamental.app.feature_splash.presentation.register

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jagamental.app.R
import com.jagamental.app.core.presentation.util.Screen
import com.jagamental.app.feature_splash.presentation.login.LoginViewModel
import com.jagamental.app.ui.theme.JagaMentalTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val usernameState = viewModel.username.value
    val emailState = viewModel.email.value
    val passwordState = viewModel.password.value
    val confirmPasswordState = viewModel.confirmPassword.value
    val phoneNumberState = viewModel.phoneNumber.value
    val passwordVisibilityState = viewModel.passwordVisibility.value
    val confirmPasswordVisibilityState = viewModel.passwordConfirmationVisibility.value

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collectLatest { event ->
            when (event) {
                is RegisterViewModel.UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
                is RegisterViewModel.UiEvent.RegisterUserSuccess -> {
                    navController.navigate(Screen.LoginScreen.route)
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(vertical = (32).dp, horizontal = 42.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Register",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Buat akun baru kamu",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(32.dp))
            TextField(
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = null)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    Text(text = "Username")
                },
                value = usernameState,
                onValueChange = { viewModel.onEvent(RegisterEvent.ChangeUsername(it)) }
            )
            Spacer(modifier = Modifier.height(18.dp))
            TextField(
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Mail, contentDescription = null)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Email")
                },
                value = emailState,
                onValueChange = { viewModel.onEvent(RegisterEvent.ChangeEmail(it)) }
            )
            Spacer(modifier = Modifier.height(18.dp))
            TextField(
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                },
                trailingIcon = {
                    IconButton(onClick = { viewModel.onEvent(RegisterEvent.ChangePasswordVisibility(!passwordVisibilityState)) }) {
                        Icon(imageVector = if (passwordVisibilityState) Icons.Filled.VisibilityOff else Icons.Filled.Visibility, contentDescription = null)
                    }
                },
                visualTransformation = if (passwordVisibilityState) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Password")
                },
                value = passwordState,
                onValueChange = { viewModel.onEvent(RegisterEvent.ChangePassword(it)) }
            )
            Spacer(modifier = Modifier.height(18.dp))
            TextField(
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                },
                trailingIcon = {
                    IconButton(onClick = { viewModel.onEvent(RegisterEvent.ChangeConfirmPasswordVisibility(!confirmPasswordVisibilityState)) }) {
                        Icon(imageVector = if (confirmPasswordVisibilityState) Icons.Filled.VisibilityOff else Icons.Filled.Visibility, contentDescription = null)
                    }
                },
                visualTransformation = if (confirmPasswordVisibilityState) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Konfirmasi Password")
                },
                value = confirmPasswordState,
                onValueChange = { viewModel.onEvent(RegisterEvent.ChangeConfirmPassword(it)) }
            )
            Spacer(modifier = Modifier.height(18.dp))
            TextField(
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Phone, contentDescription = null)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Nomor Telepon")
                },
                value = phoneNumberState,
                onValueChange = { viewModel.onEvent(RegisterEvent.ChangePhoneNumber(it)) }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { viewModel.onEvent(RegisterEvent.RegisterUser) }
            ) {
                Text(text = "Sign Up")
            }
            Spacer(modifier = Modifier.height(18.dp))
            Text(text = "atau daftar menggunakan")
            Spacer(modifier = Modifier.height(18.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.flat_color_icons_google),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            val annotatedString = buildAnnotatedString {
                append("Sudah Punya akun? ")
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.secondary)) {
                    pushStringAnnotation("Login", "Login")
                    append("Login")
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            ClickableText(
                text = annotatedString,
                style = MaterialTheme.typography.bodyMedium,
                onClick = {
                    annotatedString.getStringAnnotations(it, it)
                        .firstOrNull()?.let { span ->
                            if (span.item == "Login") {
                                navController.navigate(Screen.LoginScreen.route)
                            }
                        }
                }
            )
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    JagaMentalTheme {
        Surface {
            RegisterScreen(rememberNavController())
        }
    }
}