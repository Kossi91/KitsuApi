package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.PostLikes
import com.google.gson.annotations.SerializedName

data class PostLikesDto(
    @SerializedName("links")
    val links: LinksDto
)

fun PostLikesDto.toDomain(): PostLikes = PostLikes(
    links.toDomain()
)