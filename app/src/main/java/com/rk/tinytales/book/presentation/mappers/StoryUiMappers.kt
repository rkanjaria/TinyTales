package com.rk.tinytales.book.presentation.mappers

import com.rk.tinytales.book.domain.models.Story
import com.rk.tinytales.book.presentation.models.StoryUi

fun StoryUi.toStory(): Story {

    return Story(
        title = title,
        story = story,
        author = author,
        moral = moral,
    )
}