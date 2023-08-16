package com.example.data.network.remote.dtos.createpost

import com.example.domain.models.createpost.CreatePostData
import com.google.gson.annotations.SerializedName

data class CreatePostDataDto(
    @SerializedName("attributes")
    val attributes: CreatePostAttributesDto,
    @SerializedName("relationships")
    val relationships: CreatePostRelationshipsDto,
    @SerializedName("type")
    var type: String = "posts"
)

fun CreatePostDataDto.toDomain(): CreatePostData = CreatePostData(
    attributes.toDomain(), relationships.toDomain(), type
)
