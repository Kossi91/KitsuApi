package com.example.kitsuapi

import android.app.Application
import com.example.di.dataModule
import com.example.domain.di.domainModule
import com.example.kitsuapi.di.appModule
import com.example.kitsuapi.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * [App] Класс App наследуется от Application и используется для настройки и инициализации
 * приложения. В методе onCreate() инициализируется Koin
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        /**
         * [startKoin] - метод из Koin, который позволяет настроить контейнер зависимостей и запустить его.
        [androidContext] - метод из Koin, который позволяет передать контекст приложения, чтобы Koin мог использовать его при создании зависимостей.
        [modules] - метод из Koin, который принимает список модулей для инициализации. В данном случае передается список модулей, объединенный с помощью метода listOf.
        Модули (appModule, networkModule, dataModule, domainModule) содержат определения зависимостей и их конфигурацию, которые будут использоваться при создании объектов в приложении.
         */
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, networkModule, dataModule, domainModule))
        }
    }
}