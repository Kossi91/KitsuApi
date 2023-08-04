package com.example.data.network.remote.dtos.anime

import com.example.domain.models.anime.Anime
import com.google.gson.annotations.SerializedName

data class AnimeDto(
    @SerializedName("attributes")
    val attributes: AttributesDto,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)

fun AnimeDto.toDomain(): Anime = Anime(
    attributes.toDomain(),
    id, type
)