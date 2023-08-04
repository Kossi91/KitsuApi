package com.example.kitsuapi.presentation.models.anime

import com.example.domain.models.anime.Titles


data class TitlesUI(
    val en: String,
    val jaJp: String = "",
    val enJp: String = ""
)

fun Titles.toUI(): TitlesUI = TitlesUI(
    en, jaJp, enJp
)