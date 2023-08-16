package com.example.data.network.remote.dtos.anime

import com.example.domain.models.anime.AnimeResponce
import com.google.gson.annotations.SerializedName

data class AnimeResponceDto(
    @SerializedName("data")
    val data: List<AnimeDto>,
    @SerializedName("links")
    val links: LinksDto
)

fun AnimeResponceDto.toDomain() = AnimeResponce(
    data = data.map {
        it.toDomain()
    },
    links.toDomain()
)