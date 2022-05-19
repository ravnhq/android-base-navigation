package com.example.ravn_navigation.auth.onboarding

import androidx.navigation.NavDestination
import androidx.navigation.NavDestinationBuilder
import com.example.ravn_navigation.nav.NavFragmentRoute

object AuthOnboardingRoute : NavFragmentRoute() {

    private const val PATH = "auth/onboarding"

    override val routeDefinition = PATH

    fun createRoute() = PATH

    override fun <D : NavDestination> NavDestinationBuilder<D>.setupNav() {
        // NOTHING TO DO HERE
    }
}
