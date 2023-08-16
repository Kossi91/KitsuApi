package com.example.domain.models.post


data class PostResponse(
    val data: List<DataItem>,
    val meta: Meta,
    val links: Links
)