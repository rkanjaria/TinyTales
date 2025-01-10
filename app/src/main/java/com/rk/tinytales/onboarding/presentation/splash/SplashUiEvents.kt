package com.rk.tinytales.onboarding.presentation.splash

sealed class SplashUiEvents {
    data object NavigateToHomeScreen : SplashUiEvents()
    data object StartLogoAnimation : SplashUiEvents()
    data object EndLogoAnimation : SplashUiEvents()
}