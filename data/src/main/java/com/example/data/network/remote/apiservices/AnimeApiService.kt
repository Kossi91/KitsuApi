package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.anime.AnimeDto
import com.example.data.network.remote.dtos.anime.AnimeResponceDto
import com.example.data.network.remote.dtos.anime.detail.AnimeDetailDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("anime")
    suspend fun getAnime(
        @Query("page[limit]") limit: Int = 10,
        @Query("page[offset]") offset: Int = 10
    ): AnimeResponceDto<AnimeDto>
}