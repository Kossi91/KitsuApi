package com.example.data.network.repostories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.network.remote.apiservices.AnimeApiService
import com.example.data.network.remote.pagingsource.AnimePagingSource
import com.example.domain.models.anime.Anime
import com.example.domain.repostories.AnimeRepository
import kotlinx.coroutines.flow.Flow

/**
 * Класс [AnimeRepositoryImpl] является реализацией интерфейса [AnimeRepository].
 * Он использует сервис API [AnimeApiService] для получения данных о аниме.
 */
class AnimeRepositoryImpl
    (private val apiService: AnimeApiService) :
    AnimeRepository {

    /**
     * Метод [fetchAnime] возвращает объект Flow<PagingData<Data>> для постраничного
     * получения данных об аниме. Он использует объект Pager для настройки параметров
     * постраничного получения и pagingSourceFactory для создания объекта AnimePagingSource,
     * который реализует загрузку страниц данных. В метод можно передать параметры
     * для поиска и фильтрации по категориям.
     */
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
