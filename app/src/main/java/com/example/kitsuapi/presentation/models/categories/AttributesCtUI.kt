package com.example.kitsuapi.presentation.models.categories

import com.example.domain.models.categories.AttributesCt


data class AttributesCtUI(
    val createdAt: String = "",
    val nsfw: Boolean = false,
    val description: String = "",
    val totalMediaCount: Int = 0,
    val childCount: Int = 0,
    val title: String = "",
    val slug: String = "",
    val updatedAt: String = "",
    var isClick: Boolean = false
)

fun AttributesCt.toUI(): AttributesCtUI = AttributesCtUI(
    createdAt, nsfw, description, totalMediaCount, childCount, title, slug, updatedAt
)