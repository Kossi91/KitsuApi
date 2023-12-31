package com.example.domain.repostories

import androidx.paging.PagingData
import com.example.domain.models.anime.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    fun fetchAnime(text: String?, categories: List<String>?): Flow<PagingData<Anime>>
}