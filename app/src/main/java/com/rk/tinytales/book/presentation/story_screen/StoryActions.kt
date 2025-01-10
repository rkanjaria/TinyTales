package com.rk.tinytales.book.presentation.story_screen

sealed interface StoryActions {
    data class SendMessage(val message: String) : StoryActions
}