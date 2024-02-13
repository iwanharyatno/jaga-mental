package com.jagamental.app.feature_main.presentation.article_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.jagamental.app.feature_main.domain.model.Article
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun ArticleDetailScreen(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
    viewModel: ArticleDetailViewModel = hiltViewModel()
) {
    ArticleDetailScreenPure(
        navController = navController,
        tabController = tabController,
        snackbarHostState = snackbarHostState,
        state = viewModel.uiState.value,
        onEvent = {  }
    )
}
@Composable
fun ArticleDetailScreenPure(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
    state: ArticleDetailState,
    onEvent: (ArticleDetailEvent) -> Unit,
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 8.dp,
                    shape = MaterialTheme.shapes.small
                )
                .background(color = MaterialTheme.colorScheme.background)
                .clip(shape = MaterialTheme.shapes.small)
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = state.article.imageUrl,
                contentDescription = state.article.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9)
                    .background(color = Color.LightGray),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.padding(vertical = 18.dp, horizontal = 28.dp)
            ) {
                Text(text = state.article.content)
            }
        }
    }
}

@Preview
@Composable
fun ArticleScreenPreview() {
    JagaMentalTheme {
        Surface {
            Column {
                ArticleDetailScreenPure(
                    navController = rememberNavController(),
                    tabController = rememberNavController(),
                    snackbarHostState = SnackbarHostState(),
                    state = ArticleDetailState(
                        article = Article(
                            id = 1,
                            title = "Pentingnya Menjaga Kesehatan Mental",
                            imageUrl = "https://placehold.co/1920x1080.png",
                            content = """
                                Kesehatan mental merupakan komponen kesehatan yang tak kalah pentingnya dibandingkan dengan kesehatan fisik. Menjaga kesehatan mental menjadi landasan utama untuk mencapai kesejahteraan holistik dan kualitas hidup yang optimal. Semakin dikenalnya pentingnya aspek ini mengingatkan kita pada perlunya perhatian serius terhadap kesehatan mental sebagai bagian integral dari kehidupan sehari-hari.
                
                                Adanya tekanan  hidup modern seringkali dapat memberikan dampak negatif pada kesehatan mental seseorang. menjaga kesehatan mental menjadi langkah pertama dalam mengatasi stres dan tantangan hidup. Kesehatan mental yang baik tidak hanya melibatkan ketiadaan gangguan mental, tetapi juga mencakup kemampuan untuk mengelola emosi, menjaga hubungan yang sehat, dan memiliki kekuatan mental yang adaptif.
                            """.trimIndent()
                        )
                    ),
                    onEvent = {}
                )
            }
        }
    }
}