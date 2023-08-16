package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.DataItem

data class DataItemUI(
    val relationships: RelationshipsUI,
    val links: LinksUI,
    val attributes: AttributesUI,
    val id: String = "",
    val type: String = ""
)

fun DataItem.toUI(): DataItemUI = DataItemUI(
    relationships.toUI(), links.toUI() , attributes.toUI() , id , type
)