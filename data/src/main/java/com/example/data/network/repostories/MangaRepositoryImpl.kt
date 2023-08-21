package com.example.data.network.repostories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.network.remote.apiservices.MangaApiService
import com.example.data.network.remote.pagingsource.MangaPagingSource
import com.example.domain.models.manga.Manga
import com.example.domain.repostories.MangaRepository
import kotlinx.coroutines.flow.Flow

/**
 * Класс [MangaRepositoryImpl] является реализацией интерфейса [MangaRepository].
 * Он использует сервис API [MangaApiService] для получения данных о аниме.
 */
class MangaRepositoryImpl (private val apiService: MangaApiService): MangaRepository {
    /**
     * Метод [fetchManga] возвращает объект Flow<PagingData<Data>> для постраничного
     * получения данных об аниме. Он использует объект Pager для настройки параметров
     * постраничного получения и pagingSourceFactory для создания объекта [MangaPagingSource],
     * который реализует загрузку страниц данных. В метод можно передать параметры
     * для поиска и фильтрации по категориям.
     */
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