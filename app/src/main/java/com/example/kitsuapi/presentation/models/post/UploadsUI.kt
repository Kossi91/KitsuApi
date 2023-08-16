package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.Uploads


data class UploadsUI(
    val links: LinksUI
)

fun Uploads.toUI(): UploadsUI = UploadsUI(
    links.toUI()
)