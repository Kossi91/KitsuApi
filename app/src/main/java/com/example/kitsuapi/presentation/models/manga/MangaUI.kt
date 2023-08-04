package com.example.kitsuapi.presentation.models.manga

import com.example.domain.models.manga.Manga


data class MangaUI(
    val attributes: AttributesUI,
    val id: String = "",
    val type: String = ""
)

fun Manga.toUI(): MangaUI = MangaUI(
    attributes.toUI(),
    id, type
)