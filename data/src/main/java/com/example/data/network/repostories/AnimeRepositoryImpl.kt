package com.example.data.network.repostories

import com.example.data.network.remote.apiservices.AnimeApiService
import com.example.data.network.remote.dtos.anime.toDomain
import com.example.domain.either.Either
import com.example.domain.models.anime.Anime
import com.example.domain.repostories.AnimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimeRepositoryImpl @Inject constructor(private val apiService: AnimeApiService) : AnimeRepository{

    override fun fetchAnime() = flow<Either<String, List<Anime>>> {
        emit(Either.Right(apiService.getAnime().data.map {
            it.toDomain()
        }))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage ?: "Error Occurred!!!"))
    }
}