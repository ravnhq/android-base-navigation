package com.example.ravn_navigation.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val titleFlow: MutableStateFlow<String> = MutableStateFlow("Login")

    val registerState = LoginState(
        titleFlow = titleFlow,
        navigateToRegister = this::navigateToRegister
    )

    private fun navigateToRegister() {
        Log.wtf("JAAC", "NAVEGAR")
    }
}