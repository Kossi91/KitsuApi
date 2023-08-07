package com.example.domain.usecase

import com.example.domain.either.Either
import com.example.domain.models.user.User
import com.example.domain.repostories.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    operator fun invoke() : Flow<Either<String , List<User>>> = repository.fetchUser()
}