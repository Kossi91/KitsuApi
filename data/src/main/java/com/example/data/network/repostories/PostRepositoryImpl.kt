package com.example.data.network.repostories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.network.remote.apiservices.PostApiService
import com.example.data.network.remote.dtos.createpost.CreatePostAttributesDto
import com.example.data.network.remote.dtos.createpost.CreatePostDataDto
import com.example.data.network.remote.dtos.createpost.CreatePostDto
import com.example.data.network.remote.dtos.createpost.CreatePostRelationshipsDto
import com.example.data.network.remote.dtos.createpost.CreatePostUploadsDto
import com.example.data.network.remote.dtos.createpost.CreatePostUserDataDto
import com.example.data.network.remote.dtos.createpost.CreatePostUserDto
import com.example.data.network.remote.pagingsource.PostsPagingSource
import com.example.data.network.repostories.base.doRequest
import com.example.domain.either.Either
import com.example.domain.models.post.DataItem
import com.example.domain.repostories.PostRepository
import kotlinx.coroutines.flow.Flow

class PostRepositoryImpl(
    private val apiService: PostApiService
) : PostRepository {
    override fun fetchPosts(): Flow<PagingData<DataItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                PostsPagingSource(apiService = apiService)
            }
        ).flow
    }
    override fun createPost(
        userId: String,
        content: String,
        nsfw: Boolean,
        spoiler: Boolean
    ): Flow<Either<String, Unit>> = doRequest {
        apiService.createPost(
            CreatePostDto(
                CreatePostDataDto(
                    CreatePostAttributesDto(
                        content = content,
                        nsfw = nsfw,
                        spoiler = spoiler
                    ),
                    CreatePostRelationshipsDto(
                        CreatePostUserDto(
                            CreatePostUserDataDto(
                                id = userId
                            )
                        ),
                        CreatePostUploadsDto()
                    )
                )
            )
        )
    }
}