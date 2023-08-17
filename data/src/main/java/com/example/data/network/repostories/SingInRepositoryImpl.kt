package com.example.data.network.repostories

import com.example.data.network.remote.apiservices.SignInApiService
import com.example.data.network.remote.dtos.auth.AuthModelDto
import com.example.data.network.remote.dtos.auth.toDomain
import com.example.data.network.repostories.base.doRequest
import com.example.domain.either.Either
import com.example.domain.models.auth.LoginResponse
import com.example.domain.repostories.SingInRepository
import kotlinx.coroutines.flow.Flow

class SingInRepositoryImpl(
    private val apiService: SignInApiService
) : SingInRepository {

    override fun singIn(email: String, password: String): Flow<Either<String, LoginResponse>> =
        doRequest {
            apiService.postAuthDataUser(AuthModelDto(email = email, password = password)).toDomain()
        }
}