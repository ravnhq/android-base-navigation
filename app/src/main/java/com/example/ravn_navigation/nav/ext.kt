package com.example.ravn_navigation.nav

import android.app.Activity
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.get
import com.example.ravn_navigation.auth.AuthNav

/**
 * Add a composable route, as opposed to a fragment route, to the nav graph.
 * Todo Move this, or something like it, to Android Commons library
 */
fun NavFragmentRoute.addComposeRoute(builder: NavGraphBuilder, deepLinks: List<NavDeepLink> = emptyList(), content: @Composable (NavBackStackEntry) -> Unit) = builder.run {
    addDestination(
        ComposeNavigator.Destination(provider[ComposeNavigator::class], content).apply {
            route = routeDefinition
            setupNav()
            deepLinks.forEach { deepLink ->
                addDeepLink(deepLink)
            }
        }
    )
}

@Composable
fun MainNavGraph(navigator: Navigator, navState: NavState, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    NavHost(navigator.navController as NavHostController, StartRoute.routeDefinition, modifier) {
        StartRoute.addComposeRoute(this) { StartScreen(it.arguments, navState) }
        AuthNav.addRoutes(this)
    }
}


/**
 * Navigate to a route, logging any navigation exceptions
 * @return true if navigation succeeds
 */
fun NavController.navigateSafely(route: String, navOptions: NavOptions? = null): Boolean {
    return try {
        navigate(route, navOptions)
        true
    } catch (expected: Exception) {
        //Timber.e(expected, "navigateSafely")
        false
    }
}

/**
 * Navigate to a deep link uri, logging any navigation exceptions
 * @return true if navigation succeeds
 */
fun NavController.navigateSafely(deepLink: Uri, navOptions: NavOptions? = null): Boolean {
    return try {
        navigate(deepLink, navOptions)
        true
    } catch (expected: Exception) {
        //Timber.e(expected, "navigateSafely")
        false
    }
}

fun Activity.hideKeyboard() = KeyboardUtil.hideKeyboard(this)
fun Activity.showKeyboard() = KeyboardUtil.showKeyboard(this)