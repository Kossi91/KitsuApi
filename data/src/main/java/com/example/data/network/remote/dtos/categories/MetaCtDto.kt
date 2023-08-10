package com.example.data.network.remote.dtos.categories

import com.example.domain.models.categories.MetaCt
import com.google.gson.annotations.SerializedName

data class MetaCtDto(
    @SerializedName("count")
    val count: Int = 0
)

fun MetaCtDto.toDomain(): MetaCt = MetaCt(
    count
)