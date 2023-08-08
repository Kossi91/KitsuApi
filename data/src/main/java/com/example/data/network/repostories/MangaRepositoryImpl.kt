package com.example.data.network.repostories

import com.example.data.network.remote.apiservices.MangaApiService
import com.example.data.network.remote.pagingsource.MangaPagingSource
import com.example.data.network.repostories.base.BaseAnimeRepository
import com.example.data.network.repostories.base.BaseMangaRepository
import com.example.domain.repostories.MangaRepository
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(private val apiService: MangaApiService): MangaRepository , BaseMangaRepository(){

    override fun fetchManga()=
        doPagingRequest(MangaPagingSource(apiService))
}