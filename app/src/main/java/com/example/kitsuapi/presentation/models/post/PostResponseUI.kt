package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.PostResponse


data class PostResponseUI(
    val data: List<DataItemUI>?,
    val meta: MetaUI,
    val links: LinksUI
)

fun PostResponse.toUI(): PostResponseUI = PostResponseUI(
    data.map { it.toUI() }, meta.toUI(), links.toUI()
)