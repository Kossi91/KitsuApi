package com.example.data.network.repostories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.network.remote.apiservices.UserApiService
import com.example.data.network.remote.dtos.user.toDomain
import com.example.data.network.remote.pagingsource.UserPagingSource
import com.example.data.network.repostories.base.doRequest
import com.example.domain.either.Either
import com.example.domain.models.user.User
import com.example.domain.repostories.UserRepository
import kotlinx.coroutines.flow.Flow
/**
 * Класс [UserRepositoryImpl] реализует интерфейс [UserRepository]. Он предоставляет методы
 * для получения пользователей и информации о них с помощью API-сервиса.
 */
class UserRepositoryImpl(private val apiService: UserApiService):UserRepository {

    /**
     * [fetchUser] Получить пользователей в виде пагинации
     * @return [Flow] пагинированных данных пользователей
     */
    override fun fetchUser() : Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                UserPagingSource(apiService = apiService)
            }
        ).flow
    }

    /**
     * [fetchUsersByName] Получить список пользователей с указанным именем
     * @param name имя пользователя для поиска
     * @return [Flow] списка пользователей или ошибки
     */
    override fun fetchUsersByName(name: String?): Flow<Either<String, List<User>>> =
        doRequest {
            apiService.fetchUsersByName(name).toDomain().data
        }

    /**
     * [fetchUserByPostId] Получить пользователя по идентификатору поста
     * @param id идентификатор поста
     * @return пользователь или ошибка
     */
    override suspend fun fetchUserByPostId(id: String): User {
        return apiService.fetchUserByPostId(id).toDomain().data
    }

}