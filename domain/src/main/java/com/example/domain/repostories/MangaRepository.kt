package com.example.domain.repostories

import com.example.domain.either.Either
import com.example.domain.models.manga.Manga
import kotlinx.coroutines.flow.Flow

interface MangaRepository {

    fun fetchManga(limit : Int , offset : Int): Flow<Either<String, List<Manga>>>

}