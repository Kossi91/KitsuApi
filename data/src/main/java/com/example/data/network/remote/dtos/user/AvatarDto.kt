package com.example.data.network.remote.dtos.user

import com.example.domain.models.user.Avatar
import com.google.gson.annotations.SerializedName

data class AvatarDto(
    @SerializedName("original")
    val original: String? = null
)

fun AvatarDto.toDomain(): Avatar = Avatar(
    original
)