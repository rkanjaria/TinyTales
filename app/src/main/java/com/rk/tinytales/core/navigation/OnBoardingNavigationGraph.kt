package com.rk.tinytales.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.rk.tinytales.core.presentation.util.fadeInWithSlideOutAnimation
import com.rk.tinytales.onboarding.presentation.splash.SplashScreen
import com.rk.tinytales.onboarding.presentation.splash.SplashViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.onBoardingNavigationGraph(
    navController: NavController,
) {
    navigation<Graph.OnBoarding>(
        startDestination = SplashScreen
    ) {

        fadeInWithSlideOutAnimation<SplashScreen> {

            val viewModel: SplashViewModel = koinViewModel()
            val uiEvents = viewModel.eventFlow

            SplashScreen(
                navController = navController,
                uiEvents = uiEvents
            )
        }
    }
}