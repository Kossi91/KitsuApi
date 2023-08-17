package com.example.data.network.remote.dtos.auth

import com.example.domain.models.auth.LoginResponse

data class LoginResponseDto(
    val access_token: String,
    val token_type: String,
    val expires_in: Int,
    val refresh_token: String,
    val scope: String,
    val created_at: Int
)

fun LoginResponseDto.toDomain(): LoginResponse = LoginResponse(
    access_token, token_type, expires_in, refresh_token, scope, created_at
)
