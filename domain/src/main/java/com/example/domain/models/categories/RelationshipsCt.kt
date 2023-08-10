package com.example.domain.models.categories


data class RelationshipsCt(
    val parent: ParentCt,
    val drama: DramaCt,
    val manga: MangaCt,
    val anime: AnimeCt
)