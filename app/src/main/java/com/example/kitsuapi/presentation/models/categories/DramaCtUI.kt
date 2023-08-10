package com.example.kitsuapi.presentation.models.categories

import com.example.domain.models.categories.DramaCt

data class DramaCtUI(
    val links: LinksCtUI
)

fun DramaCt.toUI(): DramaCtUI = DramaCtUI(
    links.toUI()
)