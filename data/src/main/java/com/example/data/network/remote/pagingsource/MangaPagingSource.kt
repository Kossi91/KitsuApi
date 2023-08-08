package com.example.data.network.remote.pagingsource

import com.example.data.network.remote.apiservices.MangaApiService
import com.example.data.network.remote.dtos.manga.MangaDto
import com.example.data.network.remote.dtos.manga.toDomain
import com.example.data.network.remote.pagingsource.base.BaseMangaPagingSource
import com.example.domain.models.manga.Manga
import javax.inject.Inject

class MangaPagingSource @Inject constructor(
    private val service: MangaApiService
) : BaseMangaPagingSource<MangaDto , Manga>(
    { service.getManga(10, it)},
    {data -> data.map { it.toDomain() }}
)




