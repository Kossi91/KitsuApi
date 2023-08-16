package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.TargetGroup
import com.google.gson.annotations.SerializedName

data class TargetGroupDto(
    @SerializedName("links")
    val links: LinksDto
)

fun TargetGroupDto.toDomain(): TargetGroup = TargetGroup(
    links.toDomain()
)