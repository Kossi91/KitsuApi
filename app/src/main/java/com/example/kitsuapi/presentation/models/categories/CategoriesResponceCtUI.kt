package com.example.kitsuapi.presentation.models.categories

import com.example.domain.models.categories.CategoriesResponceCt


data class CategoriesResponceCtUI(
    val data: List<DataItemCtUI>?,
    val meta: MetaCtUI,
    val links: LinksCtUI
)