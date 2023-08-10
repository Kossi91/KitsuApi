package com.example.kitsuapi.presentation.models.categories

import com.example.domain.models.categories.MetaCt


data class MetaCtUI(
    val count: Int = 0
)

fun MetaCt.toUI(): MetaCtUI = MetaCtUI(
    count
)