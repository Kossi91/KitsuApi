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

class UserRepositoryImpl(private val apiService: UserApiService):UserRepository {
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

    override fun fetchUsersByName(name: String?): Flow<Either<String, List<User>>> =
        doRequest {
            apiService.fetchUsersByName(name).toDomain().data
        }

    override suspend fun fetchUserByPostId(id: String): User {
        return apiService.fetchUserByPostId(id).toDomain().data
    }

}