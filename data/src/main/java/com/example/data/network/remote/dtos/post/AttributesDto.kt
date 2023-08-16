package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.Attributes
import com.example.domain.models.post.Embed
import com.google.gson.annotations.SerializedName

data class AttributesDto(
    @SerializedName("contentFormatted")
    val contentFormatted: String = "",
    @SerializedName("nsfw")
    val nsfw: Boolean = false,
    @SerializedName("topLevelCommentsCount")
    val topLevelCommentsCount: Int = 0,
    @SerializedName("postLikesCount")
    val postLikesCount: Int = 0,
    @SerializedName("content")
    val content: String = "",
    @SerializedName("createdAt")
    val createdAt: String = "",
    @SerializedName("blocked")
    val blocked: Boolean = false,
    @SerializedName("commentsCount")
    val commentsCount: Int = 0,
    @SerializedName("spoiler")
    val spoiler: Boolean = false,
    @SerializedName("embed")
    val embed: Embed,
    @SerializedName("updatedAt")
    val updatedAt: String = ""
)

fun AttributesDto.toDomain(): Attributes = Attributes(
    contentFormatted, nsfw, topLevelCommentsCount, postLikesCount, content, createdAt, blocked, commentsCount, spoiler, embed, updatedAt
)