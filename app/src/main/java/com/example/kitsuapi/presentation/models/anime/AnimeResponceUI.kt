package com.example.kitsuapi.presentation.models.anime


data class AnimeResponceUI<T>(
    val data: List<T>,
    val links: LinksUI
)