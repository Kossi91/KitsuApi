package com.example.domain.repostories

import com.example.domain.either.Either
import com.example.domain.models.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun fetchUser() : Flow<Either<String , List<User>>>
}