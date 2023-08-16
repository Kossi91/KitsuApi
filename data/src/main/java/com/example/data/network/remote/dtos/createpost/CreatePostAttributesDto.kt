package com.example.data.network.remote.dtos.createpost

import com.example.domain.models.createpost.CreatePostAttributes
import com.google.gson.annotations.SerializedName

data class CreatePostAttributesDto(
    @SerializedName("content")
    val content: String,
    @SerializedName("nsfw")
    var nsfw: Boolean = false,
    @SerializedName("spooler")
    var spoiler: Boolean = false
)

fun CreatePostAttributesDto.toDomain(): CreatePostAttributes = CreatePostAttributes(
    content, nsfw, spoiler
)
