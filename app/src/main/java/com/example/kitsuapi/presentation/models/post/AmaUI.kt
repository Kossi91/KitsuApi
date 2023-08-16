package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.Ama

data class AmaUI(
    val links: LinksUI
)

fun Ama.toUI(): AmaUI = AmaUI(
    links.toUI()
)