package com.example.domain.repostories

import androidx.paging.PagingData
import com.example.domain.either.Either
import com.example.domain.models.manga.Manga
import kotlinx.coroutines.flow.Flow

interface MangaRepository {

    fun fetchManga(): Flow<PagingData<Manga>>

}