package com.jagamental.app.feature_main.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Square
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jagamental.app.feature_main.domain.model.Article
import com.jagamental.app.feature_main.domain.model.Community
import com.jagamental.app.feature_main.domain.model.Counselor
import com.jagamental.app.feature_main.presentation.home.components.ArticleList
import com.jagamental.app.feature_main.presentation.home.components.ChipFilterBand
import com.jagamental.app.feature_main.presentation.home.components.CommunityList
import com.jagamental.app.feature_main.presentation.home.components.CounselorItem
import com.jagamental.app.feature_main.presentation.home.components.SectionHeader
import com.jagamental.app.feature_main.util.NavRoute
import com.jagamental.app.ui.theme.JagaMentalTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MainHomeScreen(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
    viewModel: MainHomeViewModel = hiltViewModel()
) {
    MainHomeScreenPure(
        navController = navController,
        tabController = tabController,
        snackbarHostState = snackbarHostState,
        state = viewModel.uiState.value,
        onEvent = { viewModel.onEvent(it) }
    )
}

@Composable
private fun MainHomeScreenPure(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
    state: MainHomeState,
    onEvent: (MainHomeEvent) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 18.dp, end = 18.dp, bottom = 18.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item(
            span = { GridItemSpan(maxCurrentLineSpan) },
            key = "header"
        ) {
            Column(
                modifier = Modifier
                    .shadow(
                        elevation = 12.dp,
                        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                    )
                    .background(MaterialTheme.colorScheme.primary)
                    .layout() { measurable, constraints ->
                        val placeable = measurable.measure(
                            constraints.copy(
                                maxWidth = constraints.maxWidth + 36.dp.roundToPx(),
                            )
                        )
                        layout(placeable.width, placeable.height) {
                            placeable.place(0, 0)
                        }
                    }
                    .padding(18.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilledIconButton(
                        onClick = { /*TODO*/ },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        ),
                        shape = MaterialTheme.shapes.small
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Hai, [username]",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    FilledIconButton(
                        onClick = { /*TODO*/ },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        ),
                        shape = MaterialTheme.shapes.small
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                    FilledIconButton(
                        onClick = { /*TODO*/ },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        ),
                        shape = MaterialTheme.shapes.small
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = state.searchQuery,
                        colors = TextFieldDefaults.colors(),
                        singleLine = true,
                        onValueChange = { onEvent(MainHomeEvent.ChangeSearchQuery(it)) },
                        leadingIcon = {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                        },
                        trailingIcon = {
                            Icon(imageVector = Icons.Filled.Square, contentDescription = null)
                        },
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    FilledIconButton(
                        onClick = { /*TODO*/ },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        shape = MaterialTheme.shapes.small
                    ) {
                        Icon(imageVector = Icons.Filled.FilterList, contentDescription = null)
                    }
                }
            }
        }
        item(
            span = { GridItemSpan(maxCurrentLineSpan) },
            key = "spacer-1"
        ) {
            Spacer(modifier = Modifier.height(4.dp))
        }
        item(
            span = { GridItemSpan(maxCurrentLineSpan) },
            key = "news"
        ) {
            Column {
                SectionHeader(
                    title = "Berita Terbaru",
                    onAllClick = {
                        tabController.navigate(NavRoute.ArticleList.route)
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                ArticleList(
                    articles = state.articles,
                    onItemClick = { article ->
                        tabController.navigate(
                            NavRoute.ArticleDetail.route + "?articleId=${article.id}"
                        )
                    }
                )
            }
        }
        item(
            span = { GridItemSpan(maxCurrentLineSpan) },
            key = "counselor-header"
        ) {
            Column {
                SectionHeader(
                    title = "Rekomendasi Konselor",
                    onAllClick = { /*TODO*/
                        CoroutineScope(Dispatchers.Default).launch {
                            snackbarHostState.showSnackbar("Not yet implemented")
                        }
                    },
                )
                Spacer(modifier = Modifier.height(8.dp))
                ChipFilterBand(
                    filters = state.filters,
                    selected = state.currentCounselorFilter,
                    onChange = { onEvent(MainHomeEvent.ChangeCounselorFilter(it)) }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        items(
            state.counselors,
            key = { "c${it.id}" }
        ) { counselor ->
            CounselorItem(
                counselor = counselor,
                onClick = {/*TODO*/
                    CoroutineScope(Dispatchers.Default).launch {
                        snackbarHostState.showSnackbar("Not yet implemented")
                    }
                },
            )
        }
        item(
            span = { GridItemSpan(maxCurrentLineSpan) },
            key = "spacer-2"
        ) {
            Spacer(modifier = Modifier.height(4.dp))
        }
        item(
            span = { GridItemSpan(maxCurrentLineSpan) },
            key = "community"
        ) {
            Column {
                SectionHeader(
                    title = "Komunitas",
                    onAllClick = { /*TODO*/
                        CoroutineScope(Dispatchers.Default).launch {
                            snackbarHostState.showSnackbar("Not yet implemented")
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                CommunityList(communities = state.communities)
            }
        }
    }
}

@Preview
@Composable
fun MainHomePreview() {
    JagaMentalTheme {
        Surface {
            MainHomeScreenPure(
                navController = rememberNavController(),
                tabController = rememberNavController(),
                state = MainHomeState(
                    articles = listOf(
                        Article(1, "", "")
                    ),
                    counselors = listOf(
                        Counselor(1, "Random person with cool name", "", 4.8, true),
                        Counselor(2, "Random person with cool name", "", 4.8, true),
                        Counselor(3, "Random person with cool name", "", 4.3),
                        Counselor(4, "Random person with cool name", "", 4.3),
                    ),
                    communities = listOf(
                        Community(1, "", ""),
                        Community(2, "", ""),
                        Community(3, "", ""),
                        Community(4, "", ""),
                        Community(5, "", ""),
                        Community(6, "", ""),
                    )
                ),
                onEvent = {},
                snackbarHostState = SnackbarHostState()
            )
        }
    }
}