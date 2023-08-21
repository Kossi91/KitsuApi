package com.example.data.network.remote.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.network.remote.apiservices.MangaApiService
import com.example.data.network.remote.dtos.manga.toDomain
import com.example.domain.models.manga.Manga
/**
 * Класс [MangaPagingSource] реализует PagingSource, который является источником данных для
 * PagingData. Он загружает страницы данных из сервера и конвертирует их в Data объекты.
 * Конструктор класса MangaPagingSource принимает [MangaApiService], текст для фильтрации и
 * список категорий для фильтрации.
 */
class MangaPagingSource (
    private val apiService: MangaApiService,
    private val text: String?,
    private val categories: List<String>?
) : PagingSource<Int , Manga>(){

    /**
     * Метод [load] загружает данные для запрошенной страницы и возвращает LoadResult, который содержит
     * данные для этой страницы, предыдущий ключ и следующий ключ. Если при загрузке произошла ошибка,
     * он возвращает LoadResult.Error.
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Manga> {
        val pageIndex = params.key ?: 0

        return try {
            val response = apiService.getManga(
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

    /**
     * Метод [getRefreshKey] возвращает ключ для обновления данных. Он используется, когда пользователь
     * перезагружает список данных, чтобы обновить его. Возвращает ключ последней загруженной страницы.
     */
    override fun getRefreshKey(state: PagingState<Int, Manga>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}



