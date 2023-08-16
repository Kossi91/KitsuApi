package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.Comments
import com.google.gson.annotations.SerializedName

data class CommentsDto(
    @SerializedName("links")
    val links: LinksDto
)

fun CommentsDto.toDomain() : Comments = Comments(
    links.toDomain()
)