package com.example.data.network.repostories

import com.example.data.network.remote.apiservices.CategoriesApiService
import com.example.data.network.remote.dtos.categories.toDomain
import com.example.data.network.repostories.base.doRequest
import com.example.domain.either.Either
import com.example.domain.models.categories.DataItemCt
import com.example.domain.repostories.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val apiService: CategoriesApiService
) : CategoriesRepository {

    override fun fetchCategories(): Flow<Either<String, List<DataItemCt>>> = doRequest {
        apiService.getCategories(300).data.map{
            it.toDomain()
        }
    }
}