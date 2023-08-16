package com.example.domain.usecase

import com.example.domain.repostories.MangaRepository

class MangaUseCase(
    private val repository: MangaRepository
) {

    operator fun invoke(text: String?, categories: List<String>? ) = repository.fetchManga(text,categories)
}