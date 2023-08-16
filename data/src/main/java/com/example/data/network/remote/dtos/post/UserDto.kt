package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.User
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("links")
    val links: LinksDto
)

fun UserDto.toDomain(): User = User(
    links.toDomain()
)