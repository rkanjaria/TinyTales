package com.rk.tinytales.book.presentation.story_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.rk.tinytales.core.domain.util.stories
import com.rk.tinytales.core.navigation.StoryScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlin.time.Duration.Companion.seconds

class StoryViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val data = savedStateHandle.toRoute<StoryScreen>()

    private val _state = MutableStateFlow(
        StoryUiState(stories = stories)
    )
    val state = _state
        .onStart {
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds),
            initialValue = StoryUiState(
                stories = stories
            )
        )

    fun onAction(action: StoryActions) {
        when (action) {
            is StoryActions.SendMessage -> {

            }
        }
    }
}