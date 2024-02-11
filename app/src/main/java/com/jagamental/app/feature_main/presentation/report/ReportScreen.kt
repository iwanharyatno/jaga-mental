package com.jagamental.app.feature_main.presentation.report

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jagamental.app.R
import com.jagamental.app.feature_main.presentation.report.components.ReportCard
import com.jagamental.app.ui.theme.BlueDepressed
import com.jagamental.app.ui.theme.GreenViolence
import com.jagamental.app.ui.theme.JagaMentalTheme
import com.jagamental.app.ui.theme.RedHarassment
import com.jagamental.app.ui.theme.YellowBullying

@Composable
fun ReportScreen(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
) {
    ReportScreenPure(
        navController = navController,
        tabController = tabController,
        snackbarHostState = snackbarHostState
    )
}

@Composable
fun ReportScreenPure(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Laporkan!",
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .weight(0.5f)
                .shadow(
                    elevation = 8.dp,
                    shape = MaterialTheme.shapes.medium
                )
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(32.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp),
        ) {
            item {
                ReportCard(
                    title = "Bullying",
                    smallTitle = "Kasus",
                    cover = painterResource(id = R.mipmap.bullying_report),
                    onClick = { /*TODO*/ },
                    color = YellowBullying
                )
            }
            item {
                ReportCard(
                    title = "Pelecehan",
                    smallTitle = "Kasus",
                    cover = painterResource(id = R.mipmap.harrasment_report),
                    onClick = { /*TODO*/ },
                    color = RedHarassment
                )
            }
            item {
                ReportCard(
                    title = "Depresi",
                    smallTitle = "Kasus",
                    cover = painterResource(id = R.mipmap.depression_report),
                    onClick = { /*TODO*/ },
                    color = BlueDepressed
                )
            }
            item {
                ReportCard(
                    title = "Kekerasan",
                    smallTitle = "Kasus",
                    cover = painterResource(id = R.mipmap.violence_report),
                    onClick = { /*TODO*/ },
                    color = GreenViolence
                )
            }
        }
    }
}

@Preview
@Composable
fun ReportScreenPreview() {
    JagaMentalTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ReportScreenPure(
                    navController = rememberNavController(),
                    tabController = rememberNavController(),
                    snackbarHostState = SnackbarHostState()
                )
            }
        }
    }
}