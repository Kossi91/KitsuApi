package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.createpost.CreatePostDto
import com.example.data.network.remote.dtos.post.PostResponseDto
import retrofit2.http.*

interface PostApiService {
    @GET("api/edge/posts")
    suspend fun getPosts(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int,
        @Query("sort") sort: String = "createdAt"
    ): PostResponseDto

    @Headers("Content-Type: application/vnd.api+json")
    @POST("api/edge/posts")
    suspend fun createPost(
        @Body body: CreatePostDto?
    )
}