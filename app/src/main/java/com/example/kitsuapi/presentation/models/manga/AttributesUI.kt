package com.example.kitsuapi.presentation.models.manga

import com.example.domain.models.manga.Attributes


data class AttributesUI(
    val description: String = "",
    val posterImage: PosterImageUI,
    val titles: TitlesUI,
    val status: String = ""
)

fun Attributes.toUI(): AttributesUI = AttributesUI(
    description,
    posterImage.toUI(),
    titles.toUI(),
    status
)