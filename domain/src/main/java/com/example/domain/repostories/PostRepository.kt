package com.example.domain.repostories

import androidx.paging.PagingData
import com.example.domain.either.Either
import com.example.domain.models.post.DataItem
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun fetchPosts(): Flow<PagingData<DataItem>>

    fun createPost(
        userId: String,
        content: String,
        nsfw: Boolean,
        spoiler: Boolean
    ): Flow<Either<String, Unit>>
}