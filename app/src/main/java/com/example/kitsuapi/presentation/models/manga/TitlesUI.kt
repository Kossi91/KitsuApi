package com.example.kitsuapi.presentation.models.manga

import com.example.domain.models.manga.Titles


data class TitlesUI(
    val enUs: String = "",
    val enJp: String = ""
)

fun Titles.toUI():TitlesUI = TitlesUI(
    enUs, enJp
)