package com.example.domain.models.createpost

data class CreatePostAttributes(
    val content: String,
    var nsfw: Boolean = false,
    var spoiler: Boolean = false
)
