package com.rk.tinytales.book.presentation.story_screen


sealed interface StoryUiEvents {
    data object AnimateAndScrollToBottom : StoryUiEvents
    data object ScrollToBottom : StoryUiEvents
}