package com.example.data.network.remote.dtos.createpost

import com.example.domain.models.createpost.CreatePostUser
import com.google.gson.annotations.SerializedName

data class CreatePostUserDto(
    @SerializedName("data")
    val data: CreatePostUserDataDto
)

fun CreatePostUserDto.toDomain(): CreatePostUser = CreatePostUser(
    data.toDomain()
)