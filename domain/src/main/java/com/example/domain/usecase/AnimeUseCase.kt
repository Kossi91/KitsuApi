package com.example.domain.usecase

import com.example.domain.repostories.AnimeRepository

class AnimeUseCase(
    private val repository: AnimeRepository
){
    operator fun invoke(text: String?, categories: List<String>?) = repository.fetchAnime(text, categories)

}