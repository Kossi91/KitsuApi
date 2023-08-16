package com.example.data.network.remote.dtos.user

import com.example.domain.models.user.Attributes
import com.example.domain.models.user.Avatar
import com.google.gson.annotations.SerializedName

data class AttributesDto(
    @SerializedName("avatar")
    val avatar: Avatar? = null,
    @SerializedName("name")
    val name: String = "",
)

fun AttributesDto.toDomain(): Attributes = Attributes(
    avatar, name
)


