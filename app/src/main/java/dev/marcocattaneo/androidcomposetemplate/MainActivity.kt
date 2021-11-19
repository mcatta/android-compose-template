package dev.marcocattaneo.androidcomposetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.marcocattaneo.androidcomposetemplate.navigation.NavigationComponent
import dev.marcocattaneo.androidcomposetemplate.navigation.NavigationControllerImpl
import dev.marcocattaneo.androidcomposetemplate.navigation.composable
import dev.marcocattaneo.androidcomposetemplate.ui.screen.Routes
import dev.marcocattaneo.androidcomposetemplate.ui.screen.login.LoginScreen
import dev.marcocattaneo.androidcomposetemplate.ui.screen.login.LoginViewModel
import dev.marcocattaneo.androidcomposetemplate.ui.theme.AndroidcomposetemplateTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostState = rememberNavController()
            val controller = NavigationControllerImpl(navHostState)
            AndroidcomposetemplateTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(
                        startRoute = Routes.LoginRoute,
                        navigationController = controller
                    ) {

                        composable<LoginViewModel>(
                            route = Routes.LoginRoute,
                            navigationController = controller
                        ) { _, vm ->
                            LoginScreen(vm)
                        }
                    }
                }
            }
        }
    }
}