package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.Media
import com.google.gson.annotations.SerializedName

data class MediaDto(
    @SerializedName("links")
    val links: LinksDto
)

fun MediaDto.toDomain(): Media = Media(
    links.toDomain()
)