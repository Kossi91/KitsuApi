package com.example.data.network.remote.dtos.user

import com.example.domain.models.user.User
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("attributes")
    val attributes: AttributesDto,
    @SerializedName("id")
    val id: String = "",
)

fun UserDto.toDomain(): User = User(
    attributes.toDomain(), id
)