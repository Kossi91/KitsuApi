package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.manga.MangaDto
import com.example.data.network.remote.dtos.manga.MangaResponceDto
import com.example.data.network.remote.dtos.manga.detail.MangaDetailDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("edge/manga")
    suspend fun getManga(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): MangaResponceDto<MangaDto>

    @GET("edge/manga/{id}")
    suspend fun getDetailManga(
        @Path("id") id: Int
    ): MangaDetailDto
}