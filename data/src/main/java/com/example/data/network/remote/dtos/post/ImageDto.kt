package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.Image
import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("width")
    val width: Int = 0,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("height")
    val height: Int = 0
)

fun ImageDto.toDomain(): Image = Image(
    width, type, url, height
)