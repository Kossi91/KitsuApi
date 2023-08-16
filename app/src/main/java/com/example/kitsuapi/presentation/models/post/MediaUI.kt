package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.Media


data class MediaUI(
    val links: LinksUI
)

fun Media.toUI(): MediaUI = MediaUI(
    links.toUI()
)