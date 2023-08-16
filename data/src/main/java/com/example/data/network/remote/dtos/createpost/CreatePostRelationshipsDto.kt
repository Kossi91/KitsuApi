package com.example.data.network.remote.dtos.createpost

import com.example.domain.models.createpost.CreatePostRelationships
import com.example.domain.models.createpost.CreatePostUploads
import com.example.domain.models.createpost.CreatePostUser
import com.google.gson.annotations.SerializedName

data class CreatePostRelationshipsDto(
    @SerializedName("user")
    val user: CreatePostUserDto,
    @SerializedName("uploads")
    val uploads: CreatePostUploadsDto,
)

fun CreatePostRelationshipsDto.toDomain(): CreatePostRelationships = CreatePostRelationships(
    user.toDomain(), uploads.toDomain()
)
