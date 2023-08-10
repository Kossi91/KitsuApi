package com.example.domain.usecase

import com.example.domain.repostories.AnimeRepository
import javax.inject.Inject

class AnimeUseCase @Inject constructor(
    private val repository: AnimeRepository
){
    operator fun invoke(text: String?, categories: List<String>?) = repository.fetchAnime(text, categories)

}