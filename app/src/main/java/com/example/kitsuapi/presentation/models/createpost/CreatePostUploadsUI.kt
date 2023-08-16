package com.example.kitsuapi.presentation.models.createpost

import com.example.domain.models.createpost.CreatePostUploads


data class CreatePostUploadsUI(
    val data: List<Any>? = emptyList()
)

fun CreatePostUploads.toUI(): CreatePostUploadsUI = CreatePostUploadsUI(
    data
)
