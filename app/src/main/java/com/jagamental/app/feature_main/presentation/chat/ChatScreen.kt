package com.jagamental.app.feature_main.presentation.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.jagamental.app.feature_main.domain.model.Chat
import com.jagamental.app.feature_main.domain.model.Message
import com.jagamental.app.feature_main.presentation.chat.components.ChatList
import com.jagamental.app.ui.theme.JagaMentalTheme

@Composable
fun ChatScreen(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
    viewModel: ChatViewModel = hiltViewModel()
) {
    ChatScreenPure(
        navController = navController,
        tabController = tabController,
        snackbarHostState = snackbarHostState,
        state = viewModel.uiState.value,
        onEvent = { viewModel.onEvent(it) }
    )
}

@Composable
fun ChatScreenPure(
    navController: NavController,
    tabController: NavHostController,
    snackbarHostState: SnackbarHostState,
    state: ChatState,
    onEvent: (ChatEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 18.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Chatting",
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        OutlinedTextField(
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            },
            value = state.searchQuery,
            onValueChange = { onEvent(ChatEvent.ChangeSearchQuery(it)) },
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(18.dp))
        ChatList(chats = state.chats)
    }
}

@Preview
@Composable
fun ChatScreenPreview() {
    JagaMentalTheme {
        Surface {
            ChatScreenPure(
                state = ChatState(
                    chats = listOf(
                        Chat(
                            id = 1,
                            imgUrl = "",
                            title = "Komunitas Save Healthy",
                            messages = listOf(
                                Message(
                                    id = 1,
                                    text = "Hello world"
                                )
                            )
                        )
                    )
                ),
                onEvent = {},
                snackbarHostState = SnackbarHostState(),
                navController = rememberNavController(),
                tabController = rememberNavController()
            )
        }
    }
}