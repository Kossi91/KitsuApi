package com.example.kitsuapi.presentation.models.categories

import com.example.domain.models.categories.MangaCt


data class MangaCtUI(
    val links: LinksCtUI
)

fun MangaCt.toUI(): MangaCtUI = MangaCtUI(
    links.toUI()
)