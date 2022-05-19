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
import kotlinx.coroutines.flow.StateFlow


@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    LoginScreenContent(viewModel.registerState)
}

data class LoginState(
    val titleFlow: StateFlow<String>,
    val navigateToRegister: () -> Unit
)

@Composable
private fun LoginScreenContent(state: LoginState) {
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
                Text("ONBOARDING")
            }
        }
    }
}

@Composable
@Preview
private fun preview() {
    val loginState = LoginState(
        titleFlow = MutableStateFlow("TEST"),
        navigateToRegister = {}
    )

    LoginScreenContent(state = loginState)
}