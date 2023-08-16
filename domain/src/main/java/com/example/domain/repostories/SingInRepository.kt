package com.example.domain.repostories

import com.example.domain.either.Either
import com.example.domain.models.auth.LoginResponse
import kotlinx.coroutines.flow.Flow

interface SingInRepository {

    fun singIn(email: String, password: String): Flow<Either<String, LoginResponse>>

}