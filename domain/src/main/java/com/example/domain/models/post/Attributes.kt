package com.example.domain.models.post

data class Attributes(
    val contentFormatted: String = "",
    val nsfw: Boolean = false,
    val topLevelCommentsCount: Int = 0,
    val postLikesCount: Int = 0,
    val content: String = "",
    val createdAt: String = "",
    val blocked: Boolean = false,
    val commentsCount: Int = 0,
    val spoiler: Boolean = false,
    val embed: Embed,
    val updatedAt: String = ""
)