package com.example.data.network.remote.dtos.categories

import com.example.domain.models.categories.AnimeCt
import com.example.domain.models.categories.DramaCt
import com.example.domain.models.categories.MangaCt
import com.example.domain.models.categories.ParentCt
import com.example.domain.models.categories.RelationshipsCt
import com.google.gson.annotations.SerializedName

data class RelationshipsCtDto(
    @SerializedName("parent")
    val parent: ParentCt,
    @SerializedName("drama")
    val drama: DramaCt,
    @SerializedName("manga")
    val manga: MangaCt,
    @SerializedName("anime")
    val anime: AnimeCt
)

fun RelationshipsCtDto.toDomain(): RelationshipsCt = RelationshipsCt(
    parent, drama, manga, anime
)