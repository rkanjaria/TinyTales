package com.rk.tinytales.book.presentation.home_screen

sealed interface HomeActions {
    data class SendMessage(val message: String) : HomeActions
}