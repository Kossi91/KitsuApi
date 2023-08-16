package com.example.data.network.remote.dtos.user

import com.example.domain.models.user.UserResponce
import com.example.domain.models.user.UserResponse
import com.google.gson.annotations.SerializedName

data class UserResponceDto(
    @SerializedName("data")
    val data: List<UserDto>,
    @SerializedName("links")
    val links: LinksDto
)

data class UserResponseDto(
    @SerializedName("data")
    val data: UserDto
)

fun UserResponceDto.toDomain() : UserResponce = UserResponce(
    data.map { it.toDomain() } , links.toDomain()
)

fun UserResponseDto.toDomain(): UserResponse = UserResponse(
    data.toDomain()
)
