package com.example.data.network.remote.pagingsource

import com.example.data.network.remote.apiservices.AnimeApiService
import com.example.data.network.remote.dtos.anime.AnimeDto
import com.example.data.network.remote.dtos.anime.toDomain
import com.example.data.network.remote.pagingsource.base.BaseAnimePagingSource
import com.example.domain.models.anime.Anime
import javax.inject.Inject

class AnimePagingSource @Inject constructor(
    private val service: AnimeApiService
) : BaseAnimePagingSource<AnimeDto , Anime>(
    { service.getAnime(10, it)},
    {data -> data.map { it.toDomain() }}
)




