package com.example.kitsuapi.di

import com.example.data.network.repostories.AnimeRepositoryImpl
import com.example.data.network.repostories.MangaRepositoryImpl
import com.example.domain.repostories.AnimeRepository
import com.example.domain.repostories.MangaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindAnimeRepository(repositoryImpl: AnimeRepositoryImpl): AnimeRepository

    @Binds
    fun bindMangaRepository(repositoryImpl: MangaRepositoryImpl): MangaRepository
}