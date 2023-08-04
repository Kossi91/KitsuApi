package com.example.data.network.remote.dtos.manga

import com.example.domain.models.manga.Titles
import com.google.gson.annotations.SerializedName

data class TitlesDto(
    @SerializedName("en_us")
    val enUs: String = "",
    @SerializedName("en_jp")
    val enJp: String = ""
)
fun TitlesDto.toDomain(): Titles = Titles(
    enUs, enJp
)