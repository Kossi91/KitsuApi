package com.example.kitsuapi

import android.app.Application
import com.example.di.dataModule
import com.example.domain.di.domainModule
import com.example.kitsuapi.di.appModule
import com.example.kitsuapi.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, networkModule, dataModule, domainModule))
        }
    }
}