package com.example.data.network.repostories

import com.example.data.network.remote.apiservices.MangaApiService
import com.example.data.network.remote.dtos.manga.toDomain
import com.example.domain.either.Either
import com.example.domain.models.manga.Manga
import com.example.domain.repostories.MangaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(private val apiService: MangaApiService): MangaRepository {

    override fun fetchManga() = flow<Either<String, List<Manga>>> {
        emit(Either.Right(apiService.getManga().data.map {
            it.toDomain()
        }))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage ?: "Error  Occurred!!!"))
    }
}