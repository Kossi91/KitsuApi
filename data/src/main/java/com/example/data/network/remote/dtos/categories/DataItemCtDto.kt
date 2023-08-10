package com.example.data.network.remote.dtos.categories

import com.example.domain.models.categories.DataItemCt
import com.google.gson.annotations.SerializedName

data class DataItemCtDto(
    @SerializedName("relationships")
    val relationships: RelationshipsCtDto,
    @SerializedName("links")
    val links: LinksCtDto,
    @SerializedName("attributes")
    val attributes: AttributesCtDto,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)

fun DataItemCtDto.toDomain(): DataItemCt = DataItemCt(
    relationships.toDomain(), links.toDomain(), attributes.toDomain(), id, type
)