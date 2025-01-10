package com.rk.tinytales.book.presentation.story_screen

import com.rk.tinytales.book.presentation.models.StoryUi

data class StoryUiState(
    val isLoading: Boolean = false,
    val stories: List<StoryUi> = emptyList()
)