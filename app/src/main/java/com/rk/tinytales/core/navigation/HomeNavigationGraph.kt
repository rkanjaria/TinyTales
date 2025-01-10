package com.rk.tinytales.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rk.tinytales.book.presentation.home_screen.HomeScreen
import com.rk.tinytales.book.presentation.home_screen.HomeViewModel
import com.rk.tinytales.book.presentation.story_screen.StoryScreen
import com.rk.tinytales.book.presentation.story_screen.StoryViewModel
import com.rk.tinytales.core.presentation.util.fadeScreenAnimation
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeNavigationGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = HomeScreen
    ) {

        fadeScreenAnimation<HomeScreen> {

            val viewModel: HomeViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            HomeScreen(
                navController = navController,
                state = state,
                onAction = viewModel::onAction
            )
        }

        fadeScreenAnimation<StoryScreen> {

            val viewModel: StoryViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            StoryScreen(
                navController = navController,
                state = state,
                onAction = viewModel::onAction
            )
        }
    }
}

