package com.rk.tinytales.book.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rk.tinytales.book.presentation.home_screen.components.StoriesSection
import com.rk.tinytales.book.presentation.home_screen.components.StoryCard
import com.rk.tinytales.core.domain.util.stories
import com.rk.tinytales.core.navigation.StoryScreen
import com.rk.tinytales.ui.theme.DarkTheme
import com.rk.tinytales.ui.theme.TinyTalesTheme
import com.rk.tinytales.ui.theme.size
import com.rk.tinytales.ui.theme.title


@Composable
fun HomeScreen(
    navController: NavController,
    state: HomeUiState,
    onAction: (HomeActions) -> Unit
) {

    val stories = state.stories

    val promptColors = listOf(
        DarkTheme.cardColorGreen,
        DarkTheme.cardColorPurple,
        DarkTheme.cardColorYellow,
        DarkTheme.cardColorPink,
        DarkTheme.cardColorDarkGreen,
    )


    Box(
        modifier = Modifier
            .statusBarsPadding()
            .imePadding()
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surface,
                        MaterialTheme.colorScheme.background,
                    )
                )
            )
    ) {


        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = {
                navController.navigate(StoryScreen)
            }) {
            Text(text = "Open details")
        }

        /*LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                top = MaterialTheme.size.extraLarge,
                start = MaterialTheme.size.extraLarge,
                end = MaterialTheme.size.extraLarge,
                bottom = MaterialTheme.size.dp100.plus(
                    WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
                )
            ),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.size.extraLarge),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.size.extraLarge)
        ) {

            item(
                span = { GridItemSpan(maxLineSpan) },
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = MaterialTheme.size.extraLarge,
                            end = MaterialTheme.size.extraLarge,
                        ),
                    text = "All Tales",
                    style = MaterialTheme.title.megaLarge.copy(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 40.sp,
                        lineHeight = 50.sp
                    ),
                )
            }

            items(stories.size) { index ->

                val color = promptColors[index % promptColors.size]
                val story = stories[index]

                *//*StoriesSection(
                    storyList = stories,
                    onStoryClicked = { storyUi ->
                        navController.navigate(StoryScreen)
                    }
                )*//*


                StoryCard(
                    story = story,
                    color = color,
                    onPromptClicked = {}
                )
            }
        }*/
    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    TinyTalesTheme {

        HomeScreen(
            navController = rememberNavController(),
            state = HomeUiState(
                stories = stories,
            ),
            onAction = {}
        )
    }
}