package com.example.kitsuapi.presentation.models.manga


data class MangaResponceUI<T>(
    val data: List<T>,
    val links: LinksUI
)