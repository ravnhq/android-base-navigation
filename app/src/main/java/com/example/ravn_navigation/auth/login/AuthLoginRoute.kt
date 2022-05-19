package com.example.ravn_navigation.auth.login

import androidx.navigation.NavDestination
import androidx.navigation.NavDestinationBuilder
import androidx.navigation.NavType
import com.example.ravn_navigation.nav.NavFragmentRoute
import com.example.ravn_navigation.nav.RouteUtil

object AuthLoginRoute : NavFragmentRoute() {

    object Arg {
        const val GREATING = "greating"
    }

    private const val PATH = "auth/login"

    override val routeDefinition = "$PATH?${RouteUtil.defineOptionalArgs(Arg.GREATING)}"

    fun createRoute(greating: String? = null) = "$PATH?${RouteUtil.optionalArgs(Arg.GREATING to greating)}"

    override fun <D : NavDestination> NavDestinationBuilder<D>.setupNav() {
        argument(Arg.GREATING) {
            type = NavType.StringType
            nullable = true
            defaultValue = "hello world"
        }
    }
}
