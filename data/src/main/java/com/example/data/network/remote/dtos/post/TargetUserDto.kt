package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.TargetUser
import com.google.gson.annotations.SerializedName

data class TargetUserDto(
    @SerializedName("links")
    val links: LinksDto
)

fun TargetUserDto.toDomain(): TargetUser = TargetUser(
    links.toDomain()
)