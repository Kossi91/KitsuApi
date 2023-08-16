package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.Comments

data class CommentsUI(
    val links: LinksUI
)

fun Comments.toUI(): CommentsUI = CommentsUI(
    links.toUI()
)