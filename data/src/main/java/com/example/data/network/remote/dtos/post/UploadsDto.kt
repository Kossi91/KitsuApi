package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.Uploads
import com.google.gson.annotations.SerializedName

data class UploadsDto(
    @SerializedName("links")
    val links: LinksDto
)

fun UploadsDto.toDomain(): Uploads = Uploads(
    links.toDomain()
)