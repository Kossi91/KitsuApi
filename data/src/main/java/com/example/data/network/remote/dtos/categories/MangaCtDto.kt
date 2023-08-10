package com.example.data.network.remote.dtos.categories

import com.example.domain.models.categories.LinksCt
import com.example.domain.models.categories.MangaCt
import com.google.gson.annotations.SerializedName

data class MangaCtDto(@SerializedName("links")
                 val links: LinksCt
)

fun MangaCtDto.toDomain(): MangaCt = MangaCt(
    links
)