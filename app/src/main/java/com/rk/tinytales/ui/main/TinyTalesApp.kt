package com.rk.tinytales.ui.main

import android.app.Application
import com.rk.tinytales.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TinyTalesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TinyTalesApp)
            androidLogger()
            modules(appModule)
        }
    }
}
