package com.example.data.network.remote.dtos.categories

import com.google.gson.annotations.SerializedName

data class CategoriesResponceCtDto(
    @SerializedName("data")
    val data: List<DataItemCtDto>,
    @SerializedName("meta")
    val meta: MetaCtDto,
    @SerializedName("links")
    val links: LinksCtDto
)