package com.example.data.network.repostories

import com.example.data.network.remote.apiservices.AnimeApiService
import com.example.data.network.remote.pagingsource.AnimePagingSource
import com.example.data.network.repostories.base.BaseAnimeRepository
import com.example.domain.repostories.AnimeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimeRepositoryImpl @Inject constructor
    (private val apiService: AnimeApiService) :
    AnimeRepository , BaseAnimeRepository(){

    override fun fetchAnime()=
        doPagingRequest(AnimePagingSource(apiService))
}
