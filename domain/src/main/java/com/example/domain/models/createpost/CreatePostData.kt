package com.example.domain.models.createpost


data class CreatePostData(
    val attributes: CreatePostAttributes,
    val relationships: CreatePostRelationships,
    var type: String = "posts"
)
