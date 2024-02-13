package com.jagamental.app.feature_main.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.Note
import androidx.compose.material.icons.outlined.Report
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jagamental.app.feature_main.presentation.article_detail.ArticleDetailScreen
import com.jagamental.app.feature_main.presentation.articles.ArticleScreen
import com.jagamental.app.feature_main.presentation.chat.ChatScreen
import com.jagamental.app.feature_main.presentation.home.MainHomeScreen
import com.jagamental.app.feature_main.presentation.music.MusicScreen
import com.jagamental.app.feature_main.presentation.notes.NoteScreen
import com.jagamental.app.feature_main.presentation.report.ReportScreen
import com.jagamental.app.feature_main.util.NavRoute
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun MainScreen(
    navController: NavController
) {
    val navHostController = rememberNavController()
    val currentDestination = navHostController.currentBackStackEntryAsState().value?.destination
    val snackBarHostState = remember {
        SnackbarHostState()
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
                    )
                    .defaultMinSize(minHeight = 70.dp)
            ) {
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == NavRoute.Home.route } == true,
                    onClick = { navHostController.navigate(NavRoute.Home.route) },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Home")
                    }
                )
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == NavRoute.Chat.route } == true,
                    onClick = { navHostController.navigate(NavRoute.Chat.route) },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Chat,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Chat")
                    }
                )
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == NavRoute.Music.route } == true,
                    onClick = { navHostController.navigate(NavRoute.Music.route) },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.LibraryMusic,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Musik")
                    }
                )
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == NavRoute.Note.route } == true,
                    onClick = { navHostController.navigate(NavRoute.Note.route) },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Note,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Catatan")
                    }
                )
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == NavRoute.Report.route } == true,
                    onClick = { navHostController.navigate(NavRoute.Report.route) },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Report,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Lapor")
                    }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            NavHost(
                navController = navHostController,
                startDestination = NavRoute.Home.route,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = NavRoute.Home.route) {
                    MainHomeScreen(
                        navController = navController,
                        tabController = navHostController,
                        snackbarHostState = snackBarHostState,
                    )
                }

                composable(route = NavRoute.Chat.route) {
                    ChatScreen(
                        navController = navHostController,
                        tabController = navHostController,
                        snackbarHostState = snackBarHostState,
                    )
                }

                composable(route = NavRoute.Music.route) {
                    MusicScreen(
                        navController = navHostController,
                        tabController = navHostController,
                        snackbarHostState = snackBarHostState,
                    )
                }

                composable(route = NavRoute.Note.route) {
                    NoteScreen(
                        navController = navHostController,
                        tabController = navHostController,
                        snackbarHostState = snackBarHostState,
                    )
                }

                composable(route = NavRoute.Report.route) {
                    ReportScreen(
                        navController = navHostController,
                        tabController = navHostController,
                        snackbarHostState = snackBarHostState,
                    )
                }

                composable(route = NavRoute.ArticleList.route) {
                    ArticleScreen(
                        navController = navHostController,
                        tabController = navHostController,
                        snackbarHostState = snackBarHostState,
                    )
                }

                composable(
                    route = NavRoute.ArticleDetail.route + "?articleId={articleId}",
                    arguments = listOf(
                        navArgument(
                            name = "articleId"
                        ) {
                            type = NavType.IntType
                            defaultValue = -1
                        }
                    )
                ) {
                    ArticleDetailScreen(
                        navController = navHostController,
                        tabController = navHostController,
                        snackbarHostState = snackBarHostState,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    JagaMentalTheme {
        Surface {
            MainScreen(navController = rememberNavController())
        }
    }
}