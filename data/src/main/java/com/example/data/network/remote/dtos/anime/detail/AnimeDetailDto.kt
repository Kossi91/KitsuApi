package com.example.data.network.remote.dtos.anime.detail

import com.example.data.network.remote.dtos.anime.AnimeDto
import com.google.gson.annotations.SerializedName

data class AnimeDetailDto(
    @SerializedName("data")
    val data: AnimeDto
)