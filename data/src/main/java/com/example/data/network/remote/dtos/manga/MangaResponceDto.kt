package com.example.data.network.remote.dtos.manga

import com.example.data.network.remote.dtos.anime.LinksDto
import com.google.gson.annotations.SerializedName

data class MangaResponceDto<T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("links")
    val links: LinksDto
)