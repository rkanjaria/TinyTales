package com.rk.tinytales.di


import com.rk.tinytales.book.data.StoryDataSourceImpl
import com.rk.tinytales.book.domain.StoryDataSource
import com.rk.tinytales.book.presentation.home_screen.HomeViewModel
import com.rk.tinytales.book.presentation.story_screen.StoryViewModel
import com.rk.tinytales.onboarding.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    single { StoryDataSourceImpl() }.bind(StoryDataSource::class)

    viewModelOf(::SplashViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::StoryViewModel)
}