package com.example.kitsuapi.presentation.models.user

import com.example.kitsuapi.presentation.models.anime.LinksUI


data class UserResponceUI<T>(
    val data: List<UserUI>?,
    val links: LinksUI
)