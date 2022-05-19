package com.example.ravn_navigation.nav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.ravn_navigation.auth.login.AuthLoginRoute
import com.example.ravn_navigation.auth.onboarding.AuthOnboardingRoute

@Composable
fun NavScreen(scaffoldState: ScaffoldState) {
    val navigator = LocalNavigator.current ?: return
    val state = rememberNavState()
    Scaffold(
        scaffoldState = scaffoldState,
    ) { padding ->
        Box(Modifier.padding(padding)) {
            MainNavGraph(navigator, state)
            navigator.navController.navigateSafely(AuthLoginRoute.createRoute())
        }
    }
}

data class NavState(
    val loginFlow: MutableState<Boolean> = mutableStateOf(false),
)

@Composable
fun rememberNavState(): NavState {
    return remember {
        NavState(
            loginFlow = mutableStateOf(false),
        )
    }
}