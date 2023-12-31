package com.example.data.network.remote.dtos.anime

import com.example.domain.models.anime.Titles
import com.google.gson.annotations.SerializedName

data class TitlesDto(
    @SerializedName("ja_jp")
    val jaJp: String = "",
    @SerializedName("en_jp")
    val enJp: String = ""
)

fun TitlesDto.toDomain(): Titles =Titles(
     jaJp, enJp
)