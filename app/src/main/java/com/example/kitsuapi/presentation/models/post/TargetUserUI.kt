package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.TargetUser


data class TargetUserUI(
    val links: LinksUI
)

fun TargetUser.toUI(): TargetUserUI = TargetUserUI(
    links.toUI()
)