package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.Embed

data class EmbedUI(
    val image: ImageUI,
    val kind: String = "",
    val title: String = "",
    val url: String = ""
)

fun Embed.toUI(): EmbedUI = EmbedUI(
    image.toUI(), kind, title, url
)