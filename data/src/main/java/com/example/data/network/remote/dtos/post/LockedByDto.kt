package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.LockedBy
import com.google.gson.annotations.SerializedName

data class LockedByDto(
    @SerializedName("links")
    val links: LinksDto
)

fun LockedByDto.toDomain(): LockedBy = LockedBy(
    links.toDomain()
)