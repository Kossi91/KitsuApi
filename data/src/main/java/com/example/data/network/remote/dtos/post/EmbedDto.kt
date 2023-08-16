package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.Embed
import com.google.gson.annotations.SerializedName

data class EmbedDto(
    @SerializedName("image")
    val image: ImageDto,
    @SerializedName("kind")
    val kind: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = ""
)

fun EmbedDto.toDomain(): Embed = Embed(
    image.toDomain(), kind, title, url
)