package com.jagamental.app.core.presentation.util

sealed class Screen(val route: String) {
    object HomeSplashScreen : Screen("home-splash-screen")
    object LoginScreen : Screen("login-screen")
    object RegisterScreen : Screen("register-screen")
    object MainScreen : Screen("main-screen")
}
