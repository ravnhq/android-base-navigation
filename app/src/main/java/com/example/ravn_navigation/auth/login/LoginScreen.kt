package com.example.ravn_navigation.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ravn_navigation.auth.onboarding.AuthOnboardingRoute
import com.example.ravn_navigation.nav.LocalNavigator
import kotlinx.coroutines.flow.MutableStateFlow


@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    LoginScreenContent(viewModel.registerState)
}


@Composable
private fun LoginScreenContent(state: LoginUiState) {
    val title by state.titleFlow.collectAsState()

    val navController = LocalNavigator.current
    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = title)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            Button(onClick = { navController?.navigateSafely(AuthOnboardingRoute.createRoute()) }) {
                Text("GO TO ONBOARDING")
            }
        }
    }
}

@Composable
@Preview
private fun preview() {
    val loginState = LoginUiState(
        titleFlow = MutableStateFlow("TEST")
    )

    LoginScreenContent(state = loginState)
}