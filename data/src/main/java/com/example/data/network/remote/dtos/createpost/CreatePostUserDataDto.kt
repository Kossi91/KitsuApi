package com.example.data.network.remote.dtos.createpost

import com.example.domain.models.createpost.CreatePostUserData
import com.google.gson.annotations.SerializedName

data class CreatePostUserDataDto(
    @SerializedName("type")
    val type: String = "users",
    @SerializedName("id")
    val id: String
)

fun CreatePostUserDataDto.toDomain(): CreatePostUserData = CreatePostUserData(
    type, id
)

