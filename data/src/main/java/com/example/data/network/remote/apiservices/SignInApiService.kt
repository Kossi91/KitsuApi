package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.auth.AuthModelDto
import com.example.data.network.remote.dtos.auth.TokenModelDto
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST("oauth/token")
    suspend fun postAuthDataUser(
        @Body authModel: AuthModelDto
    ): TokenModelDto
}
