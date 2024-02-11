package com.jagamental.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jagamental.app.core.presentation.util.Screen
import com.jagamental.app.feature_main.presentation.MainScreen
import com.jagamental.app.feature_splash.presentation.home.HomeScreen
import com.jagamental.app.feature_splash.presentation.login.LoginScreen
import com.jagamental.app.feature_splash.presentation.register.RegisterScreen
import com.jagamental.app.ui.theme.JagaMentalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JagaMentalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeSplashScreen.route,
                        enterTransition = {
                            slideInHorizontally()
                        },
                        exitTransition = {
                            slideOutHorizontally()
                        },
                        popEnterTransition = {
                            slideInHorizontally()
                        },
                        popExitTransition = {
                            slideOutHorizontally()
                        }
                    ) {
                        composable( route = Screen.HomeSplashScreen.route ) {
                            HomeScreen(navController = navController)
                        }
                        composable( route = Screen.LoginScreen.route ) {
                            LoginScreen(navController = navController)
                        }
                        composable( route = Screen.RegisterScreen.route ) {
                            RegisterScreen(navController = navController)
                        }
                        composable( route = Screen.MainScreen.route ) {
                            MainScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}