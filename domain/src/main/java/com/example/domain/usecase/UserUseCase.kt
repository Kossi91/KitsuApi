package com.example.domain.usecase

import com.example.domain.repostories.UserRepository

class UserUseCase (
    private val repository: UserRepository
) {

    operator fun invoke() =repository.fetchUser()
}