package com.example.data.network.repostories

import com.example.data.network.remote.apiservices.UserApiService
import com.example.data.network.remote.dtos.user.toDomain
import com.example.domain.either.Either
import com.example.domain.models.user.User
import com.example.domain.repostories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: UserApiService):UserRepository {
    override fun fetchUser() = flow <Either<String, List<User>>> {
        emit(Either.Right(apiService.getUser().data.map {
            it.toDomain()
        }))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage ?: "Error Occurred!!!"))
    }
}