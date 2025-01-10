package com.rk.tinytales.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rk.tinytales.core.presentation.util.slideScreenAnimation
import com.rk.tinytales.ui.main.MainScreen
import kotlinx.serialization.Serializable

@Composable
fun RootNavigationGraph(
    onBoardingNavController: NavHostController,
    homeNavController: NavHostController,
) {

    NavHost(
        navController = onBoardingNavController,
        startDestination = Graph.OnBoarding
    ) {

        slideScreenAnimation<Graph.Home> {
            MainScreen(navController = homeNavController)
        }

        onBoardingNavigationGraph(
            navController = onBoardingNavController
        )
    }
}

object Graph {

    @Serializable
    data object OnBoarding

    @Serializable
    data object Home
}