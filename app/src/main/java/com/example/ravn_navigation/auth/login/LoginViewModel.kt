package com.example.ravn_navigation.auth.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val titleFlow: MutableStateFlow<String> = MutableStateFlow("Login")

    val registerState = LoginUiState(
        titleFlow = titleFlow,
    )
}