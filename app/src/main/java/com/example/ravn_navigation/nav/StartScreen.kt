package com.example.ravn_navigation.nav

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.ravn_navigation.auth.AuthNav
import com.example.ravn_navigation.nav.NavState

@Composable
fun StartScreen(arguments: Bundle?, navState: NavState) {
    LaunchedEffect(arguments) {
        navState.loginFlow.value = true
    }
}
