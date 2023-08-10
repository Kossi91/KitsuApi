package com.example.data.network.remote.dtos.categories

import com.example.domain.models.categories.LinksCt
import com.example.domain.models.categories.ParentCt
import com.google.gson.annotations.SerializedName

data class ParentCtDto(
    @SerializedName("links")
    val links: LinksCt
)

fun ParentCtDto.toDomain(): ParentCt = ParentCt(
    links
)