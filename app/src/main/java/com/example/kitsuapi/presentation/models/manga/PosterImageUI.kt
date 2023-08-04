package com.example.kitsuapi.presentation.models.manga

import com.example.domain.models.manga.PosterImage


data class PosterImageUI(
    val small: String = "",
    val original: String = "",
    val large: String = "",
    val medium: String = ""
)
 fun PosterImage.toUI(): PosterImageUI = PosterImageUI(
     small, original, large, medium
 )