package com.example.kitsuapi.presentation.models.createpost

import com.example.domain.models.createpost.CreatePostAttributes

data class CreatePostAttributesUI(
    val content: String,
    var nsfw: Boolean = false,
    var spoiler: Boolean = false
)

fun CreatePostAttributes.toUI(): CreatePostAttributesUI = CreatePostAttributesUI(
    content, nsfw, spoiler
)