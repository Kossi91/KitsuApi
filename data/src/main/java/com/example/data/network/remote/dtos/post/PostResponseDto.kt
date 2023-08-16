package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.PostResponse
import com.google.gson.annotations.SerializedName

data class PostResponseDto(
    @SerializedName("data")
    val data: List<DataItemDto>,
    @SerializedName("meta")
    val meta: MetaDto,
    @SerializedName("links")
    val links: LinksDto
)

fun PostResponseDto.toDomain(): PostResponse = PostResponse(
    data.map {
        it.toDomain() },
    meta.toDomain(), links.toDomain()
)