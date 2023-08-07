package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.user.UserDto
import com.example.data.network.remote.dtos.user.UserResponceDto
import retrofit2.http.GET

interface UserApiService {

    @GET("users")
    suspend fun getUser(): UserResponceDto<UserDto>
}