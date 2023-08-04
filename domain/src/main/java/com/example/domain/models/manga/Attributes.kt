package com.example.domain.models.manga


data class Attributes(
    val description: String = "",
    val posterImage: PosterImage,
    val titles: Titles,
    val status: String = ""
)