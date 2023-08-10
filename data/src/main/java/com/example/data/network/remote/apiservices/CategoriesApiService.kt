package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.categories.CategoriesResponceCtDto
import retrofit2.http.*

interface CategoriesApiService {

    @GET("edge/categories")
    suspend fun getCategories(
        @Query("page[limit]") limit: Int
    ): CategoriesResponceCtDto
}