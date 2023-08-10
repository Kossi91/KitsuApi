package com.example.domain.models.categories


data class AttributesCt(
    val createdAt: String = "",
    val nsfw: Boolean = false,
    val description: String = "",
    val totalMediaCount: Int = 0,
    val childCount: Int = 0,
    val title: String = "",
    val slug: String = "",
    val updatedAt: String = ""
)