package com.example.data.network.remote.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.network.remote.apiservices.AnimeApiService
import com.example.data.network.remote.dtos.anime.toDomain
import com.example.domain.models.anime.Anime
import javax.inject.Inject

class AnimePagingSource @Inject constructor(
private val apiService: AnimeApiService,
private val text: String?,
private val categories: List<String>?,
) : PagingSource<Int, Anime>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        val pageIndex = params.key ?: 0

        return try {
            val response = apiService.getAnime(
                limit = params.loadSize, offset = pageIndex, text = text,
                categories = categories
            ).toDomain()
            LoadResult.Page(
                data = response.data,
                nextKey = if (response.data.size == params.loadSize) pageIndex + params.loadSize else null,
                prevKey = null
            )

        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Anime>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}



