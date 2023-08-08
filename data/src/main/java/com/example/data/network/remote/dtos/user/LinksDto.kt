package com.example.data.network.remote.dtos.user

import com.example.domain.models.manga.Links
import com.google.gson.annotations.SerializedName

data class LinksDto(
    @SerializedName("next")
    val next: String?,
    @SerializedName("last")
    val last: String = "",
    @SerializedName("first")
    val first: String = ""
)

fun LinksDto.toDomain(): Links = Links(
    next, last, first
)