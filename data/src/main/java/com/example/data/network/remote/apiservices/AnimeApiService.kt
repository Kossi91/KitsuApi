package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.anime.AnimeDto
import com.example.data.network.remote.dtos.anime.AnimeResponceDto
import com.example.data.network.remote.dtos.anime.detail.AnimeDetailDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("edge/anime")
    suspend fun getAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int,
        @Query("filter[text]") text: String?,
        @Query("filter[categories]") categories: List<String>?
    ): AnimeResponceDto
}