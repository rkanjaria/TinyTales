package com.rk.tinytales.book.presentation.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.rk.tinytales.book.presentation.models.StoryUi
import com.rk.tinytales.ui.theme.DarkTheme
import com.rk.tinytales.ui.theme.TinyTalesTheme
import com.rk.tinytales.ui.theme.size


@Composable
fun StoriesSection(
    modifier: Modifier = Modifier,
    storyList: List<StoryUi>,
    onStoryClicked: (StoryUi) -> Unit = {}
) {

    val promptColors = listOf(
        DarkTheme.cardColorGreen,
        DarkTheme.cardColorPurple,
        DarkTheme.cardColorYellow,
        DarkTheme.cardColorPink,
        DarkTheme.cardColorDarkGreen,
    )

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(
            start = MaterialTheme.size.extraLarge,
            end = MaterialTheme.size.extraLarge,
        ),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.size.extraLarge)
    ) {

        items(storyList.size) { index ->
            val color = promptColors[index % promptColors.size]
            val prompt = storyList[index]
            StoryCard(
                story = prompt,
                color = color,
                onPromptClicked = onStoryClicked
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun PromptSectionPreview() {
    TinyTalesTheme {
        StoriesSection(
            modifier = Modifier.fillMaxWidth(),
            storyList = emptyList()
        )
    }
}