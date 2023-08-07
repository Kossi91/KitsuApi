package com.example.domain.usecase

import com.example.domain.either.Either
import com.example.domain.models.anime.Anime
import com.example.domain.repostories.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeUseCase @Inject constructor(
    private val repository: AnimeRepository
){
    operator fun invoke(): Flow<Either<String, List<Anime>>> = repository.fetchAnime()
}