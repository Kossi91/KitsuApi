package com.example.data.network.remote.dtos.categories

import com.example.domain.models.categories.DramaCt
import com.example.domain.models.categories.LinksCt
import com.google.gson.annotations.SerializedName

data class DramaCtDto(@SerializedName("links")
                 val links: LinksCt
)

fun DramaCtDto.toDomain(): DramaCt = DramaCt(
    links
)