package com.rk.tinytales.book.presentation.home_screen

import com.rk.tinytales.book.presentation.models.StoryUi

data class HomeUiState(
    val isLoading: Boolean = false,
    val stories: List<StoryUi> = emptyList(),
)