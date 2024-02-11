package com.jagamental.app.feature_splash.presentation.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jagamental.app.R
import com.jagamental.app.core.presentation.util.Screen
import com.jagamental.app.ui.theme.JagaMentalTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val usernameState = viewModel.username.value
    val passwordState = viewModel.password.value
    val passwordVisibleState = viewModel.passwordVisible.value

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collectLatest {event ->
            when (event) {
                is LoginViewModel.UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
                is LoginViewModel.UiEvent.LoginUserSuccess -> {
                    navController.navigate(Screen.MainScreen.route)
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.mipmap.bg_ellipse),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    painter = painterResource(id = R.mipmap.psychologist_illustration),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight()
                        .scale(1.25f),
                    contentScale = ContentScale.FillHeight
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 48.dp)
            ) {

                TextField(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    value = usernameState,
                    placeholder = {
                        Text(text = "Username")
                    },
                    onValueChange = {
                        viewModel.onEvent(LoginEvent.ChangeUsername(it))
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { viewModel.onEvent(LoginEvent.ChangePasswordVisible(!passwordVisibleState)) }) {
                            Icon(imageVector = if (passwordVisibleState) Icons.Filled.VisibilityOff else Icons.Filled.Visibility , contentDescription = null)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    value = passwordState,
                    visualTransformation = if (passwordVisibleState) VisualTransformation.None else PasswordVisualTransformation(),
                    placeholder = {
                        Text(text = "Password")
                    },
                    onValueChange = {
                        viewModel.onEvent(LoginEvent.ChangePassword(it))
                    }
                )
                Button(
                    modifier = Modifier
                        .padding(top = 18.dp)
                        .fillMaxWidth(),
                    onClick = { viewModel.onEvent(LoginEvent.LoginUser) }
                ) {
                    Text(text = "Sign In")
                }
                val annotatedString = buildAnnotatedString {
                    append("Belum Punya akun? ")
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.secondary)) {
                        pushStringAnnotation("Register", "Register")
                        append("Register")
                    }
                }
                ClickableText(
                    modifier = Modifier.padding(top = 12.dp),
                    text = annotatedString,
                    style = MaterialTheme.typography.bodyMedium,
                    onClick = {
                        annotatedString.getStringAnnotations(it, it)
                            .firstOrNull()?.let { span ->
                                if (span.item == "Register") {
                                    navController.navigate(Screen.RegisterScreen.route)
                                }
                            }
                    }
                )
                Spacer(modifier = Modifier.height(18.dp))
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    JagaMentalTheme {
        Surface {
            LoginScreen(navController = rememberNavController())
        }
    }
}