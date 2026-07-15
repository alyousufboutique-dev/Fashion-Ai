package com.fashionai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fashionai.ui.navigation.Routes
import com.fashionai.ui.screens.splash.SplashScreen
import com.fashionai.ui.screens.onboarding.OnboardingScreen
import com.fashionai.ui.screens.home.HomeScreen
import com.fashionai.ui.theme.FashionAITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FashionAITheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.SPLASH
                    ) {
                        composable(Routes.SPLASH) {
                            SplashScreen(navController = navController)
                        }
                        composable(Routes.ONBOARDING) {
                            OnboardingScreen(navController = navController)
                        }
                        composable(Routes.HOME) {
                            HomeScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
