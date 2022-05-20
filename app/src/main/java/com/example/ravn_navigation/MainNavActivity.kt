package com.example.ravn_navigation

import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import com.example.ravn_navigation.nav.LocalNavigator
import com.example.ravn_navigation.nav.NavHelper
import com.example.ravn_navigation.nav.NavScreen
import com.example.ravn_navigation.nav.Navigator
import com.example.ravn_navigation.nav.hideKeyboard
import com.example.ravn_navigation.nav.navigateSafely
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import javax.inject.Inject

@AndroidEntryPoint
class MainNavActivity : AppCompatActivity(), Navigator {
    @Inject
    override lateinit var navHelper: NavHelper
    override lateinit var navController: NavHostController
    lateinit var scaffoldState: ScaffoldState


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            scaffoldState = rememberScaffoldState()
            navController = rememberNavController()
            CompositionLocalProvider(LocalNavigator provides this@MainNavActivity) {
                NavScreen(scaffoldState)
            }
        }
    }

    override fun navigateSafely(route: String, navOptions: NavOptions?) {
        navController.navigateSafely(route, navOptions)
    }

    override fun navigateSafely(deepLink: Uri, navOptions: NavOptions?) {
        navController.navigateSafely(deepLink, navOptions)
    }

    override fun popBackStack() = navController.popBackStack()

    override fun showSnackbar(textId: Int): Job = showSnackbar(getString(textId))

    override fun showSnackbar(text: String): Job = lifecycleScope.launchWhenStarted {
        hideKeyboard()
        scaffoldState.snackbarHostState.showSnackbar(text, duration = SnackbarDuration.Long)
    }

}