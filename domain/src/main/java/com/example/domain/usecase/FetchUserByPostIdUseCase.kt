package com.example.domain.usecase

import com.example.domain.repostories.UserRepository

class FetchUserByPostIdUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(id: String) = repository.fetchUserByPostId(id)
}