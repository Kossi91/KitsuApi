package com.example.kitsuapi.di

import com.example.data.local.prefs.TokenPreferenceHelper
import com.example.data.network.remote.apiservices.AnimeApiService
import com.example.data.network.remote.apiservices.CategoriesApiService
import com.example.data.network.remote.apiservices.MangaApiService
import com.example.data.network.remote.apiservices.PostApiService
import com.example.data.network.remote.apiservices.SignInApiService
import com.example.data.network.remote.apiservices.UserApiService
import com.example.data.network.repostories.AnimeRepositoryImpl
import com.example.data.network.repostories.TokenInterceptor
import com.example.domain.repostories.AnimeRepository
import com.example.domain.repostories.MangaRepository
import com.example.kitsuapi.presentation.ui.fragments.post.PostViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.binds
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

/**
 * [networkModule] networkModule
 */
val networkModule = module {
    factory { TokenInterceptor(get<TokenPreferenceHelper>()) }
    factory<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    factory { provideOkHttpClient() }
    single { provideRetrofitClient(get()) }
    factory { provideAnimeApiService(get<Retrofit>()) }
    factory { provideSingInApiService(get<Retrofit>()) }
    factory { provideMangaApiService(get<Retrofit>()) }
    factory { provideUserApiService(get<Retrofit>()) }
    factory { provideCategoriesApiService(get<Retrofit>()) }


    /**
     * [PostApiService] создается с [AuthInterceptor] так как для того чтобы опубликовать пост
     * требуется токен, в остальных запросах токен не требуется
     */
    single<PostApiService> {
        Retrofit.Builder()
            .baseUrl("https://kitsu.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient().newBuilder()
                    .addInterceptor(get<HttpLoggingInterceptor>())
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(get<TokenInterceptor>())
                    .build()
            )
            .build()
            .create(PostApiService::class.java)
    }
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
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}


fun provideAnimeApiService(retrofitClient: Retrofit): AnimeApiService {
    return retrofitClient.create(AnimeApiService::class.java)
}

fun provideMangaApiService(retrofitClient: Retrofit): MangaApiService {
    return retrofitClient.create(MangaApiService::class.java)
}

fun provideUserApiService(retrofitClient: Retrofit): UserApiService {
    return retrofitClient.create(UserApiService::class.java)
}

fun provideSingInApiService(retrofitClient: Retrofit): SignInApiService {
    return retrofitClient.create(SignInApiService::class.java)
}

fun providePostApiService(retrofitClient: Retrofit): PostApiService {
    return retrofitClient.create(PostApiService::class.java)
}

fun provideCategoriesApiService(retrofitClient: Retrofit) : CategoriesApiService{
    return retrofitClient.create(CategoriesApiService::class.java)
}