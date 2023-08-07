package com.example.domain.models.manga


data class Attributes(
    val posterImage: PosterImage,
    val titles: Titles,
    val status: String = ""
)