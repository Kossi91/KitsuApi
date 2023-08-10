package com.example.data.network.remote.dtos.categories

import com.example.domain.models.categories.AnimeCt
import com.example.domain.models.categories.LinksCt
import com.google.gson.annotations.SerializedName

data class AnimeCtDto(@SerializedName("links")
                 val links: LinksCt
)

fun AnimeCtDto.toDomain(): AnimeCt = AnimeCt(
    links
)