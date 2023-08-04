package com.example.domain.repostories

import com.example.domain.either.Either
import com.example.domain.models.anime.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    fun fetchAnime(limit : Int, offset : Int): Flow<Either<String, List<Anime>>>
}