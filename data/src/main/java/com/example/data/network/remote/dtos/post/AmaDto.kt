package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.Ama
import com.google.gson.annotations.SerializedName

data class AmaDto(
    @SerializedName("links")
    val links: LinksDto
)

fun AmaDto.toDomain(): Ama = Ama (
    links.toDomain()
)