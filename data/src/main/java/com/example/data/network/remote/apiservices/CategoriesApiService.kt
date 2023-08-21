package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.categories.CategoriesResponceCtDto
import retrofit2.http.*

/**
 * [CategoriesApiService] Api Service для работы с остальными запросами
 */
interface CategoriesApiService {
    /**
     * Получает список категорий с сервера.
     * @param limit Максимальное количество категорий на одной странице
     * @return Список категорий, упакованный в [CategoriesResponceCtDto]
     */
    @GET("edge/categories")
    suspend fun getCategories(
        @Query("page[limit]") limit: Int
    ): CategoriesResponceCtDto
}