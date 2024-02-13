package com.jagamental.app.feature_main.presentation.articles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jagamental.app.feature_main.domain.model.Article
import com.jagamental.app.feature_main.presentation.articles.components.ArticleList
import com.jagamental.app.feature_main.util.NavRoute
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun ArticleScreen(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
    viewModel: ArticleViewModel = hiltViewModel()
) {
    ArticleScreenPure(
        navController = navController,
        tabController = tabController,
        snackbarHostState = snackbarHostState,
        state = viewModel.uiState.value,
        onEvent = { viewModel.onEvent(it) }
    )
}
@Composable
fun ArticleScreenPure(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
    state: ArticleState,
    onEvent: (ArticleEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Articles",
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        OutlinedTextField(
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            },
            value = state.searchQuery,
            onValueChange = { onEvent(ArticleEvent.ChangeSearchQuery(it)) },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(18.dp))
        ArticleList(
            articles = state.articles,
            modifier = Modifier.fillMaxHeight(),
            onItemClick = {
                tabController.navigate(
                    NavRoute.ArticleDetail.route + "?articleId=" + it.id
                )
            }
        )
    }
}

@Preview
@Composable
fun ArticleScreenPreview() {
    JagaMentalTheme {
        Surface {
            Column {
                ArticleScreenPure(
                    navController = rememberNavController(),
                    tabController = rememberNavController(),
                    snackbarHostState = SnackbarHostState(),
                    state = ArticleState(
                        articles = listOf(
                            Article(
                                id = 1,
                                title = "Pentingnya Menjaga Kesehatan Mental",
                                imageUrl = "https://placehold.co/1920x1080.png"
                            ),
                            Article(
                                id = 2,
                                title = "Pentingnya Menjaga Kesehatan Mental",
                                imageUrl = "https://placehold.co/1920x1080.png"
                            ),
                            Article(
                                id = 3,
                                title = "Pentingnya Menjaga Kesehatan Mental",
                                imageUrl = "https://placehold.co/1920x1080.png"
                            ),
                            Article(
                                id = 4,
                                title = "Pentingnya Menjaga Kesehatan Mental",
                                imageUrl = "https://placehold.co/1920x1080.png"
                            )
                        )
                    ),
                    onEvent = {}
                )
            }
        }
    }
}