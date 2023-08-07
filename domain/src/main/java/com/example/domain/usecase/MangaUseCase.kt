package com.example.domain.usecase

import com.example.domain.either.Either
import com.example.domain.models.manga.Manga
import com.example.domain.repostories.MangaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MangaUseCase @Inject constructor(
    private val repository: MangaRepository
) {

    operator fun invoke(): Flow<Either<String, List<Manga>>> = repository.fetchManga()
}