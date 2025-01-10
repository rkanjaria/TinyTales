package com.rk.tinytales.book.presentation.story_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rk.tinytales.book.presentation.story_screen.components.StoryPage
import com.rk.tinytales.core.domain.util.stories
import com.rk.tinytales.ui.theme.TinyTalesTheme


@Composable
fun StoryScreen(
    navController: NavController,
    state: StoryUiState,
    onAction: (StoryActions) -> Unit
) {

    val stories = state.stories

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { stories.size }
    )

    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = pagerState,
    ) { page ->

        val story = stories[page]

        StoryPage(
            modifier = Modifier.fillMaxSize(),
            story = story
        )
    }
}

@PreviewLightDark
@Composable
private fun ChatScreenPreview() {
    TinyTalesTheme {

        StoryScreen(
            navController = rememberNavController(),
            state = StoryUiState(
                stories = stories
            ),
            onAction = {}
        )
    }
}
