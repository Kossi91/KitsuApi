package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.Attributes

data class AttributesUI(
    val contentFormatted: String = "",
    val nsfw: Boolean = false,
    val topLevelCommentsCount: Int = 0,
    val postLikesCount: Int = 0,
    val content: String = "",
    val createdAt: String = "",
    val blocked: Boolean = false,
    val commentsCount: Int = 0,
    val spoiler: Boolean = false,
    val embed: EmbedUI,
    val updatedAt: String = ""
)

fun Attributes.toUI(): AttributesUI = AttributesUI(
    contentFormatted, nsfw, topLevelCommentsCount,
    postLikesCount, content, createdAt , blocked, commentsCount, spoiler,embed.toUI(), updatedAt
)