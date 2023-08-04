package com.example.data.network.remote.dtos.anime

import com.google.gson.annotations.SerializedName

data class AnimeResponceDto<T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("links")
    val links: LinksDto
)