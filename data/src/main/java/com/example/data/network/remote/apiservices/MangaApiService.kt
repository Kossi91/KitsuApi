package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.manga.MangaResponceDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaApiService {

    @GET("edge/manga")
    suspend fun getManga(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int,
        @Query("filter[text]") text: String?,
        @Query("filter[categories]") categories: List<String>?
    ): MangaResponceDto
}