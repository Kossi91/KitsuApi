package com.example.data.network.remote.dtos.manga.detail

import com.example.data.network.remote.dtos.manga.MangaDto
import com.google.gson.annotations.SerializedName

data class MangaDetailDto(
    @SerializedName("data")
    val data: MangaDto
)