package com.example.domain.usecase

import com.example.domain.repostories.UserRepository

class FetchUserByNameUseCase(
    private val repository: UserRepository
) {
    operator fun invoke(name: String) = repository.fetchUsersByName(name)
}