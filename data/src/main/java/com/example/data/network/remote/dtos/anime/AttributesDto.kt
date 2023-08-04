package com.example.data.network.remote.dtos.anime

import com.example.domain.models.anime.Attributes
import com.google.gson.annotations.SerializedName

data class AttributesDto(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("posterImage")
    val posterImage: PosterImageDto,
    @SerializedName("titles")
    val titles: TitlesDto,
    @SerializedName("status")
    val status: String = ""
)

fun AttributesDto.toDomain(): Attributes = Attributes(
    description,
    posterImage.toDomain(),
    titles.toDomain(),
    status
)