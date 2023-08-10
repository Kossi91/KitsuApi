package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.user.UserDto
import com.example.data.network.remote.dtos.user.UserResponceDto
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {

    @GET("edge/users")
    suspend fun getUser(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): UserResponceDto<UserDto>
}