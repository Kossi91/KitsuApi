package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.SpoiledUnit

data class SpoiledUnitUI(
    val links: LinksUI
)
fun SpoiledUnit.toUI() : SpoiledUnitUI = SpoiledUnitUI(
    links.toUI()
)