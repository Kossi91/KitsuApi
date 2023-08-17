package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.user.UserResponceDto
import com.example.data.network.remote.dtos.user.UserResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApiService {

    @GET("edge/users")
    suspend fun fetchUser(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): UserResponceDto

    @GET("edge/users")
    suspend fun fetchUsersByName(
        @Query("filter[name]") name: String?
    ): UserResponceDto

    @GET("edge/posts/{id}/user")
    suspend fun fetchUserByPostId(
        @Path("id") id: String
    ): UserResponseDto
}