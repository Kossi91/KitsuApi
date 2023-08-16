package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.PostLikes


data class PostLikesUI(
    val links: LinksUI
)

fun PostLikes.toUI(): PostLikesUI = PostLikesUI(
    links.toUI()
)