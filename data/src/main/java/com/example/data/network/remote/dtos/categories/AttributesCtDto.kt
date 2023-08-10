package com.example.data.network.remote.dtos.categories

import com.example.domain.models.categories.AttributesCt
import com.google.gson.annotations.SerializedName

data class AttributesCtDto(
    @SerializedName("createdAt")
    val createdAt: String = "",
    @SerializedName("nsfw")
    val nsfw: Boolean = false,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("totalMediaCount")
    val totalMediaCount: Int = 0,
    @SerializedName("childCount")
    val childCount: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("updatedAt")
    val updatedAt: String = ""
)

fun AttributesCtDto.toDomain(): AttributesCt = AttributesCt(
    createdAt, nsfw, description, totalMediaCount, childCount, title, slug, updatedAt
)