package com.example.domain.models.manga


data class MangaResponce<T>(
    val data: List<T>,
    val links: Links
)