package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.Meta
import com.google.gson.annotations.SerializedName

data class MetaDto(
    @SerializedName("count")
    val count: Int = 0
)

fun MetaDto.toDomain(): Meta = Meta(
    count
)