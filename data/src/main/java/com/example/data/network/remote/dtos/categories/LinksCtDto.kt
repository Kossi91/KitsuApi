package com.example.data.network.remote.dtos.categories

import com.example.domain.models.categories.LinksCt
import com.google.gson.annotations.SerializedName

data class LinksCtDto(
    @SerializedName("next")
    val next: String = "",
    @SerializedName("last")
    val last: String = "",
    @SerializedName("first")
    val first: String = ""
)

fun LinksCtDto.toDomain(): LinksCt = LinksCt(
    next, last, first
)