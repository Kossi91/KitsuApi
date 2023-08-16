package com.example.kitsuapi.presentation.models.createpost

import com.example.domain.models.createpost.CreatePostRelationships


data class CreatePostRelationshipsUI(
    val user: CreatePostUserUI,
    val uploads: CreatePostUploadsUI,
)

fun CreatePostRelationships.toUI(): CreatePostRelationshipsUI = CreatePostRelationshipsUI(
    user.toUI(), uploads.toUI()
)