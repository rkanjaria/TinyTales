package com.rk.tinytales.book.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rk.tinytales.book.domain.StoryDataSource
import com.rk.tinytales.core.domain.util.stories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlin.time.Duration.Companion.seconds

class HomeViewModel(
    private val storyDataSource: StoryDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState(stories = stories))
    val state = _state.onStart {

    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds),
            initialValue = HomeUiState(stories = stories)
        )

    fun onAction(action: HomeActions) {
        when (action) {
            is HomeActions.SendMessage -> {

            }
        }
    }
}