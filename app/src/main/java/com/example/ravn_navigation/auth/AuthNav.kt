package com.example.ravn_navigation.auth

import androidx.navigation.NavGraphBuilder
import com.example.ravn_navigation.auth.login.AuthLoginRoute
import com.example.ravn_navigation.auth.login.LoginScreen
import com.example.ravn_navigation.auth.onboarding.AuthOnboardingRoute
import com.example.ravn_navigation.auth.onboarding.OnboardingScreen
import com.example.ravn_navigation.nav.addComposeRoute

object AuthNav {
    fun addRoutes(builder: NavGraphBuilder) {
        AuthLoginRoute.addComposeRoute(builder) { LoginScreen() }
        AuthOnboardingRoute.addComposeRoute(builder) { OnboardingScreen() }
    }
}
