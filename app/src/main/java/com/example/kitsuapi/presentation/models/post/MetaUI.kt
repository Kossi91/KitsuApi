package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.Meta

data class MetaUI(
    val count: Int = 0
)

fun Meta.toUI(): MetaUI = MetaUI(
    count
)