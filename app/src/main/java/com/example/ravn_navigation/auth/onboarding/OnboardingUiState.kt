package com.example.ravn_navigation.auth.onboarding

import kotlinx.coroutines.flow.StateFlow

data class OnboardingUiState(
    val titleFlow: StateFlow<String>,
    val mutableStateValue: StateFlow<List<String>>,
    val fakeValue: StateFlow<Int>,
    val fetchMoreData: () -> Unit,
)