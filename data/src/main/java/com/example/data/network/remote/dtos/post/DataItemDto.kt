package com.example.data.network.remote.dtos.post

import com.example.domain.models.post.Comments
import com.example.domain.models.post.DataItem
import com.example.domain.models.post.Relationships
import com.google.gson.annotations.SerializedName

data class DataItemDto(
    @SerializedName("relationships")
    val relationships: RelationshipsDto,
    @SerializedName("links")
    val links: LinksDto,
    @SerializedName("attributes")
    val attributes: AttributesDto,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)

fun DataItemDto.toDomain(): DataItem = DataItem(
    relationships.toDomain(), links.toDomain(), attributes.toDomain(), id, type
)