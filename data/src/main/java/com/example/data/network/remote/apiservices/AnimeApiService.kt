package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.anime.AnimeResponceDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * [AnimeApiService] Api Service для работы с аниме
 */
interface AnimeApiService {
    /**
     * [getAnime] Получает список аниме с сервера.
     * @param limit Максимальное количество элементов, которое будет возвращено в списке.
     * @param offset Cмещение элементов.
     * @param text Текст для поиска.
     * @param categories Список категорий, по которым будет производиться фильтрация.
     * @return [AnimeResponceDto] с информацией о манге.
     */
    @GET("edge/anime")
    suspend fun getAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int,
        @Query("filter[text]") text: String?,
        @Query("filter[categories]") categories: List<String>?
    ): AnimeResponceDto
}