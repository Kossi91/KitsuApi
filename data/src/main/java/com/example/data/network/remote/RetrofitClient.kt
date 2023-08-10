package com.example.data.network.remote

import com.example.data.network.remote.apiservices.AnimeApiService
import com.example.data.network.remote.apiservices.CategoriesApiService
import com.example.data.network.remote.apiservices.MangaApiService
import com.example.data.network.remote.apiservices.SignInApiService
import com.example.data.network.remote.apiservices.UserApiService
import com.example.data.network.repostories.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(TokenInterceptor())
        .callTimeout(30,TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideAnimeApiService() = retrofitClient.create(AnimeApiService::class.java)

    fun provideMangaApiService() = retrofitClient.create(MangaApiService::class.java)

    fun provideUserApiService() = retrofitClient.create(UserApiService::class.java)

    fun provideSingInApiService() = retrofitClient.create(SignInApiService::class.java)

    fun provideCategoriesApiService() = retrofitClient.create(CategoriesApiService::class.java)
}
