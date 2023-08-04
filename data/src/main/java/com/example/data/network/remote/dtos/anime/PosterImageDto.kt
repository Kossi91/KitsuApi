package com.example.data.network.remote.dtos.anime

import com.example.domain.models.anime.PosterImage
import com.google.gson.annotations.SerializedName

data class PosterImageDto(
    @SerializedName("small")
    val small: String = "",
    @SerializedName("original")
    val original: String = "",
    @SerializedName("large")
    val large: String = "",
    @SerializedName("tiny")
    val tiny: String = "",
    @SerializedName("medium")
    val medium: String = ""
)

fun PosterImageDto.toDomain() : PosterImage = PosterImage(
    small, original, large, tiny, medium
)