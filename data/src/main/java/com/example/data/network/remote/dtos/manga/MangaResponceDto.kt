package com.example.data.network.remote.dtos.manga

import com.example.domain.models.manga.MangaResponce
import com.google.gson.annotations.SerializedName

data class MangaResponceDto(
    @SerializedName("data")
    val data: List<MangaDto>,
    @SerializedName("links")
    val links:LinksDto
)

fun MangaResponceDto.toDomain() = MangaResponce(
    data = data.map {
        it.toDomain()
    },
    links = links.toDomain()
)