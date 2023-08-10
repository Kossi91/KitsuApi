package com.example.kitsuapi.di

import com.example.data.network.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideAnimeApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideAnimeApiService()

    @Provides
    @Singleton
    fun provideMangaApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideMangaApiService()

    @Provides
    @Singleton
    fun provideUserApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideUserApiService()

    @Provides
    @Singleton
    fun provideSingInApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideSingInApiService()

    @Provides
    @Singleton
    fun provideCategoriesApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideCategoriesApiService()
}