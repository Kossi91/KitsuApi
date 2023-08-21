package com.example.di

import com.example.data.local.prefs.TokenPreferenceHelper
import com.example.data.network.remote.apiservices.AnimeApiService
import com.example.data.network.remote.apiservices.CategoriesApiService
import com.example.data.network.remote.apiservices.MangaApiService
import com.example.data.network.remote.apiservices.PostApiService
import com.example.data.network.remote.apiservices.SignInApiService
import com.example.data.network.remote.apiservices.UserApiService
import com.example.data.network.repostories.AnimeRepositoryImpl
import com.example.data.network.repostories.CategoriesRepositoryImpl
import com.example.data.network.repostories.MangaRepositoryImpl
import com.example.data.network.repostories.PostRepositoryImpl
import com.example.data.network.repostories.SingInRepositoryImpl
import com.example.data.network.repostories.UserRepositoryImpl
import com.example.domain.repostories.AnimeRepository
import com.example.domain.repostories.CategoriesRepository
import com.example.domain.repostories.MangaRepository
import com.example.domain.repostories.PostRepository
import com.example.domain.repostories.SingInRepository
import com.example.domain.repostories.UserRepository
import org.koin.dsl.module
/**
 * [dataModule] koin module для зависимостей data модуля
 */
val dataModule = module {

    single<AnimeRepository> {
        AnimeRepositoryImpl(
            apiService = get<AnimeApiService>()
        )
    }

    single<CategoriesRepository> {
        CategoriesRepositoryImpl(
            apiService = get<CategoriesApiService>()
        )
    }


    single<MangaRepository> {
        MangaRepositoryImpl(
            apiService = get<MangaApiService>()
        )
    }

    single<PostRepository> {
        PostRepositoryImpl(
            apiService = get<PostApiService>()
        )
    }


    single<SingInRepository> {
        SingInRepositoryImpl(
            apiService = get<SignInApiService>()
        )
    }

    single<TokenPreferenceHelper> {
        TokenPreferenceHelper(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(
            apiService = get<UserApiService>()
        )
    }
}