package com.example.data.network.repostories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.network.remote.apiservices.AnimeApiService
import com.example.data.network.remote.dtos.anime.AnimeDto
import com.example.data.network.remote.pagingsource.AnimePagingSource
import com.example.data.network.repostories.base.BaseAnimeRepository
import com.example.domain.models.anime.Anime
import com.example.domain.repostories.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimeRepositoryImpl @Inject constructor
    (private val apiService: AnimeApiService) :
    AnimeRepository {
    override fun fetchAnime(text: String?, categories: List<String>?): Flow<PagingData<Anime>>{
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                AnimePagingSource(
                    apiService = apiService, text= text, categories = categories
                )
            }
        ).flow
    }
}
