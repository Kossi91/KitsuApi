package com.example.domain.models.categories

data class DataItemCt(
    val relationships: RelationshipsCt,
    val links: LinksCt,
    val attributes: AttributesCt,
    val id: String = "",
    val type: String = ""
)