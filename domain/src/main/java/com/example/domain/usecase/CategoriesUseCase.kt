package com.example.domain.usecase

import com.example.domain.repostories.CategoriesRepository

class CategoriesUseCase(
    private val repository: CategoriesRepository
) {
    operator fun invoke() = repository.fetchCategories()
}