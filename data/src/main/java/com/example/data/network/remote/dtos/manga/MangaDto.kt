package com.example.data.network.remote.dtos.manga

import com.example.domain.models.manga.Manga
import com.google.gson.annotations.SerializedName

data class MangaDto(
    @SerializedName("attributes")
    val attributes: AttributesDto,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)

fun MangaDto.toDomain() : Manga = Manga(
    attributes.toDomain(),
    id, type
)