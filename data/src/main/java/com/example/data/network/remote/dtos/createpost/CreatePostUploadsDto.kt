package com.example.data.network.remote.dtos.createpost

import com.example.domain.models.createpost.CreatePostUploads
import com.google.gson.annotations.SerializedName

data class CreatePostUploadsDto(
    @SerializedName("data")
    val data: List<Any>? = emptyList()
)

fun CreatePostUploadsDto.toDomain(): CreatePostUploads = CreatePostUploads(
    data
)
