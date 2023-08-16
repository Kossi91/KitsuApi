package com.example.domain.di

import com.example.domain.repostories.AnimeRepository
import com.example.domain.repostories.CategoriesRepository
import com.example.domain.repostories.MangaRepository
import com.example.domain.repostories.PostRepository
import com.example.domain.repostories.SingInRepository
import com.example.domain.repostories.UserRepository
import com.example.domain.usecase.AnimeUseCase
import com.example.domain.usecase.CategoriesUseCase
import com.example.domain.usecase.CreatePostUseCase
import com.example.domain.usecase.FetchUserByNameUseCase
import com.example.domain.usecase.FetchUserByPostIdUseCase
import com.example.domain.usecase.MangaUseCase
import com.example.domain.usecase.PostsUseCase
import com.example.domain.usecase.SingInUseCase
import com.example.domain.usecase.UserUseCase
import org.koin.dsl.module


val domainModule = module {
    factory<AnimeUseCase> {
        AnimeUseCase(repository = get<AnimeRepository>())
    }

    factory<MangaUseCase> {
        MangaUseCase(repository = get<MangaRepository>())
    }

    factory<UserUseCase> {
        UserUseCase(repository = get<UserRepository>())
    }

    factory<CategoriesUseCase> {
        CategoriesUseCase(repository = get<CategoriesRepository>())
    }

    factory<SingInUseCase> {
        SingInUseCase(repository = get<SingInRepository>())
    }

    factory<CreatePostUseCase> {
        CreatePostUseCase(repository = get<PostRepository>())
    }

    factory<FetchUserByNameUseCase> {
        FetchUserByNameUseCase(repository = get<UserRepository>())
    }

    factory<FetchUserByPostIdUseCase> {
        FetchUserByPostIdUseCase(repository = get<UserRepository>())
    }

    factory<PostsUseCase> {
        PostsUseCase(repository = get<PostRepository>())
    }
}