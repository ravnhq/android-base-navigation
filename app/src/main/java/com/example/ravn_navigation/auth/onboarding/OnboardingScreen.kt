package com.example.ravn_navigation.auth.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun OnboardingScreen(viewModel: OnboardingViewModel = hiltViewModel()) {
    LoginScreenContent(viewModel.registerState)
}

@Composable
private fun LoginScreenContent(state: OnboardingUiState) {
    val title by state.titleFlow.collectAsState()
    val valuesList by state.mutableStateValue.collectAsState()
    val fakeValue by state.fakeValue.collectAsState()
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
        ) {
            Column {
                valuesList.forEach {
                    Text(text = it)
                }
                Button(onClick = { state.fetchMoreData() }) {
                    Text("Add value$fakeValue")
                }
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    val loginState = OnboardingUiState(
        titleFlow = MutableStateFlow("TEST"),
        mutableStateValue = MutableStateFlow(listOf("HELO", "WORLD", "PREVIEW")),
        fakeValue = MutableStateFlow(1),
        fetchMoreData = {},
        navigateToRegister = {}
    )

    LoginScreenContent(state = loginState)
}