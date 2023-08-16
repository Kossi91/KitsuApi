package com.example.kitsuapi.di

import com.example.data.local.prefs.TokenPreferenceHelper
import com.example.data.network.remote.apiservices.AnimeApiService
import com.example.data.network.remote.apiservices.MangaApiService
import com.example.data.network.remote.apiservices.PostApiService
import com.example.data.network.remote.apiservices.SignInApiService
import com.example.data.network.remote.apiservices.UserApiService
import com.example.data.network.repostories.TokenInterceptor
import com.example.kitsuapi.presentation.ui.fragments.post.PostViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { TokenInterceptor(get<TokenPreferenceHelper>()) }
    factory<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    factory { provideOkHttpClient() }
    single { provideRetrofitClient(get()) }
    factory { provideAnimeApiService(get<Retrofit>()) }
    factory { provideSingInApiService(get<Retrofit>())}
    factory { provideMangaApiService(get<Retrofit>()) }
    factory { provideUserApiService(get<Retrofit>()) }
    factory { providePostApiService(get<Retrofit>()) }
}

fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient().newBuilder()
        .addInterceptor(interceptor)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()
}

fun provideAnimeApiService(retrofitClient: Retrofit) : AnimeApiService{
    return retrofitClient.create(AnimeApiService::class.java)
}

fun provideMangaApiService(retrofitClient: Retrofit): MangaApiService{
    return  retrofitClient.create(MangaApiService::class.java)
}

fun provideUserApiService(retrofitClient: Retrofit) : UserApiService{
    return retrofitClient.create(UserApiService::class.java)
}
fun provideSingInApiService(retrofitClient: Retrofit): SignInApiService {
    return retrofitClient.create(SignInApiService::class.java)
}

fun providePostApiService(retrofit: Retrofit): PostApiService {
    return retrofit.create(PostApiService::class.java)
}