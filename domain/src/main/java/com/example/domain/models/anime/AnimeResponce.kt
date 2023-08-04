package com.example.domain.models.anime


data class AnimeResponce<T>(
    val data: List<T>,
    val links: Links
)