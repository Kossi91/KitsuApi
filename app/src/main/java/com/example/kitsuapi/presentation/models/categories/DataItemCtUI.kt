package com.example.kitsuapi.presentation.models.categories

import com.example.domain.models.categories.DataItemCt

data class DataItemCtUI(
    val relationships: RelationshipsCtUI,
    val links: LinksCtUI,
    val attributes: AttributesCtUI,
    val id: String = "",
    val type: String = ""
)

fun DataItemCt.toUI(): DataItemCtUI = DataItemCtUI(
    relationships.toUI() , links.toUI(), attributes.toUI() , id, type
)