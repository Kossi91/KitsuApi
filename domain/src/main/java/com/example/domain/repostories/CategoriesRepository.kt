package com.example.domain.repostories

import com.example.domain.either.Either
import com.example.domain.models.categories.DataItemCt
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {

    fun fetchCategories(): Flow<Either<String, List<DataItemCt>>>
}