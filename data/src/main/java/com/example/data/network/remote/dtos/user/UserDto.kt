package com.example.data.network.remote.dtos.user

import com.example.domain.models.user.Attributes
import com.example.domain.models.user.User
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String = "",
)

fun UserDto.toDomain(): User = User(
    attributes,
    id
)