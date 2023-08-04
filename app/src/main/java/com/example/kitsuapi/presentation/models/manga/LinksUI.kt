package com.example.kitsuapi.presentation.models.manga

import com.example.domain.models.manga.Links


data class LinksUI(
    val next: String?,
    val last: String = "",
    val first: String = ""
)

fun Links.toUI(): LinksUI = LinksUI(
    next, last, first
)