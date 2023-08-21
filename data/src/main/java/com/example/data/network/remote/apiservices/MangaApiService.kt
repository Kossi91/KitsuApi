package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.manga.MangaResponceDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * [MangaApiService] Api Service для работы с манга
 */
interface MangaApiService {
    /**
     * [getManga] Получает список манги с сервера.
     * @param limit Максимальное количество элементов, которое будет возвращено в списке.
     * @param offset Cмещение элементов.
     * @param text Текст для поиска.
     * @param categories Список категорий, по которым будет производиться фильтрация.
     * @return [MangaResponceDto] с информацией о манге.
     */
    @GET("edge/manga")
    suspend fun getManga(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int,
        @Query("filter[text]") text: String?,
        @Query("filter[categories]") categories: List<String>?
    ): MangaResponceDto
}