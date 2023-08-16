package com.example.kitsuapi.presentation.models.createpost

import com.example.domain.models.createpost.CreatePost


data class CreatePostUI(
    val data: CreatePostDataUI
)

fun CreatePost.toUI(): CreatePostUI = CreatePostUI(
    data.toUI()
)
