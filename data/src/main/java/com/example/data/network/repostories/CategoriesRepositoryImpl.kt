package com.example.data.network.repostories

import com.example.data.network.remote.apiservices.CategoriesApiService
import com.example.data.network.remote.dtos.categories.toDomain
import com.example.data.network.repostories.base.doRequest
import com.example.domain.either.Either
import com.example.domain.models.categories.DataItemCt
import com.example.domain.repostories.CategoriesRepository
import kotlinx.coroutines.flow.Flow
/**
 * Класс [CategoriesRepositoryImpl] является реализацией интерфейса [CategoriesRepository].
 * Он использует сервис API [CategoriesApiService] для получения списка категорий.
 */
class CategoriesRepositoryImpl(
    private val apiService: CategoriesApiService
) : CategoriesRepository {

    /**
     * Метод [fetchCategories] возвращает объект Flow<Either<String,List<CategoriesData>>>,
     * который содержит результат выполнения запроса на получение списка категорий.
     * Он использует функцию makeNetworkRequest для выполнения запроса и обработки возможных ошибок.
     */
    override fun fetchCategories(): Flow<Either<String, List<DataItemCt>>> = doRequest {
        apiService.getCategories(300).data.map{
            it.toDomain()
        }
    }
}