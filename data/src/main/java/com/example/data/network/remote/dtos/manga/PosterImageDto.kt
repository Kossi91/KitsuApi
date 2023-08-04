package com.example.data.network.remote.dtos.manga

import com.example.domain.models.manga.PosterImage
import com.google.gson.annotations.SerializedName

data class PosterImageDto(
    @SerializedName("small")
    val small: String = "",
    @SerializedName("original")
    val original: String = "",
    @SerializedName("large")
    val large: String = "",
    @SerializedName("medium")
    val medium: String = ""
)

fun PosterImageDto.toDomain():PosterImage = PosterImage(
    small, original, large
)