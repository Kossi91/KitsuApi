package com.example.domain.models.user

import com.example.domain.models.manga.Links


data class UserResponce<T>(
    val data: List<T>?,
    val links: Links
)