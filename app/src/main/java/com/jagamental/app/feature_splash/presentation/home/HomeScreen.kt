package com.jagamental.app.feature_splash.presentation.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jagamental.app.R
import com.jagamental.app.core.presentation.util.Screen
import com.jagamental.app.ui.theme.Blue40
import com.jagamental.app.ui.theme.Blue50
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun HomeScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
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
                painter = painterResource(id = R.mipmap.jaga_mental_banner),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                contentScale = ContentScale.FillWidth
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 48.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Selamat datang di Aplikasi",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Jaga Mental!",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Jaga Mental diciptakan untuk tempat orang-orang yang kuat dan hebat",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                textAlign = TextAlign.Center,
            )
            Button(
                modifier = Modifier
                    .padding(top = 18.dp)
                    .fillMaxWidth(),
                onClick = { navController.navigate(Screen.LoginScreen.route) }
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

@Preview("HomeScreen")
@Composable
fun HomeScreenPreview() {
    JagaMentalTheme {
        Surface {
            HomeScreen(navController = rememberNavController())
        }
    }
}