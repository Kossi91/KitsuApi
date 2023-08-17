package com.example.data.network.repostories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.network.remote.apiservices.MangaApiService
import com.example.data.network.remote.pagingsource.MangaPagingSource
import com.example.domain.models.manga.Manga
import com.example.domain.repostories.MangaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MangaRepositoryImpl (private val apiService: MangaApiService): MangaRepository {

    override fun fetchManga(text: String?, categories: List<String>?): Flow<PagingData<Manga>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                MangaPagingSource(
                    apiService = apiService, text= text, categories = categories
                )
            }
        ).flow
    }
}