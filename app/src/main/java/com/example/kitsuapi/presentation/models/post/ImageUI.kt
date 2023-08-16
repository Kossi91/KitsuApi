package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.Image

data class ImageUI(
    val width: Int = 0,
    val type: String = "",
    val url: String = "",
    val height: Int = 0
)

fun Image.toUI(): ImageUI = ImageUI(
    width, type, url, height
)