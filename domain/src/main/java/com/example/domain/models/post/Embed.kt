package com.example.domain.models.post

data class Embed(
    val image: Image,
    val kind: String = "",
    val title: String = "",
    val url: String = ""
)