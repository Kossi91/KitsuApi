package com.example.domain.models.post

data class DataItem(
    val relationships: Relationships,
    val links: Links,
    val attributes: Attributes,
    val id: String = "",
    val type: String = ""
)