package com.example.kitsuapi.presentation.models.createpost

import com.example.domain.models.createpost.CreatePostData


data class CreatePostDataUI(
    val attributes: CreatePostAttributesUI,
    val relationships: CreatePostRelationshipsUI,
    var type: String = "posts"
)

fun CreatePostData.toUI(): CreatePostDataUI = CreatePostDataUI(
    attributes.toUI(), relationships.toUI(), type
)
