package com.example.ravn_navigation.nav

import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import kotlinx.coroutines.Job

val LocalNavigator = staticCompositionLocalOf<Navigator?> { null }

interface Navigator {

    val navHelper: NavHelper
    val navController: NavController
    
    /**
     * Navigate to a route, always hiding the keyboard and logging and reporting any navigation exceptions
     */
    fun navigateSafely(route: String, navOptions: NavOptions? = null)

    /**
     * Navigate to a route, always hiding the keyboard and logging and reporting any navigation exceptions
     */
    fun navigateSafely(route: String, builder: NavOptionsBuilder.() -> Unit) = navigateSafely(route, navOptions(builder))

    /**
     * Navigate to a deep link uri, always hiding the keyboard and logging and reporting any navigation exceptions
     */
    fun navigateSafely(deepLink: Uri, navOptions: NavOptions? = null)

    /**
     * Navigate to a deep link uri, always hiding the keyboard and logging and reporting any navigation exceptions
     */
    fun navigateSafely(deepLink: Uri, builder: NavOptionsBuilder.() -> Unit) = navigateSafely(deepLink, navOptions(builder))

    /**
     * Pops the back stack if is not empty or closes the app if it was
     */
    fun popBackStack(): Boolean

    /**
     * Show a snackBar with text from a string resource
     */
    fun showSnackbar(@StringRes textId: Int): Job

    /**
     * Show a snackBar with the given text
     */
    fun showSnackbar(text: String): Job
}
