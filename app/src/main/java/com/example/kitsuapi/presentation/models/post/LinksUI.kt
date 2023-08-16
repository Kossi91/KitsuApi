package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.Links

data class LinksUI(
    val next: String = "",
    val last: String = "",
    val first: String = ""
)

fun Links.toUI() :LinksUI = LinksUI(
    next, last, first
)