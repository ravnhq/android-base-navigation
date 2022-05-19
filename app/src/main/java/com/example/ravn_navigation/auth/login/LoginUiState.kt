package com.example.ravn_navigation.auth.login

import kotlinx.coroutines.flow.StateFlow

data class LoginUiState(
    val titleFlow: StateFlow<String>
)