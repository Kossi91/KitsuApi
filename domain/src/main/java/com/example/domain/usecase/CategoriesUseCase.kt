package com.example.domain.usecase

import com.example.domain.repostories.CategoriesRepository
import javax.inject.Inject

class CategoriesUseCase @Inject constructor(
    private val repository: CategoriesRepository
) {
    operator fun invoke() = repository.fetchCategories()
}