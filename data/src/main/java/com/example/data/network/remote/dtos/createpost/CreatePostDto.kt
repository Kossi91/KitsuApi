package com.example.data.network.remote.dtos.createpost

import com.example.domain.models.createpost.CreatePost
import com.google.gson.annotations.SerializedName

data class CreatePostDto(
    @SerializedName("data")
    val data: CreatePostDataDto
)

fun CreatePostDto.toDomain(): CreatePost = CreatePost(
    data.toDomain()
)
