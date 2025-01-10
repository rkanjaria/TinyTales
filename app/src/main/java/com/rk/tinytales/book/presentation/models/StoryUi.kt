package com.rk.tinytales.book.presentation.models

import androidx.annotation.DrawableRes

data class StoryUi(
    @DrawableRes val icon: Int,
    val id: String? = null,
    val image: String? = null,
    val title: String? = null,
    val story: String? = null,
    val author: String? = null,
    val moral: String? = null
)