package com.example.kitsuapi.presentation.models.categories

import com.example.domain.models.categories.AnimeCt

data class AnimeCtUI(
    val links: LinksCtUI
)

fun AnimeCt.toUI(): AnimeCtUI = AnimeCtUI(
    links.toUI()
)