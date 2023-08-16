package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.SpoiledUnit
import com.google.gson.annotations.SerializedName

data class SpoiledUnitDto(
    @SerializedName("links")
    val links: LinksDto
)

fun SpoiledUnitDto.toDomain(): SpoiledUnit = SpoiledUnit(
    links.toDomain()
)