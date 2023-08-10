package com.example.kitsuapi.presentation.models.categories

import com.example.domain.models.categories.RelationshipsCt


data class RelationshipsCtUI(
    val parent: ParentCtUI,
    val drama: DramaCtUI,
    val manga: MangaCtUI,
    val anime: AnimeCtUI
)

fun RelationshipsCt.toUI(): RelationshipsCtUI = RelationshipsCtUI(
    parent.toUI(), drama.toUI(), manga.toUI(), anime.toUI()
)