package com.example.domain.usecase

import com.example.domain.repostories.SingInRepository
import javax.inject.Inject


class SingInUseCase(
    private val repository: SingInRepository
) {
    operator fun invoke(email: String, password: String) = repository.singIn(email, password)
}