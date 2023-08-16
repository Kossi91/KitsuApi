package com.example.data.network.remote.dtos.auth

import com.example.domain.models.auth.LoginResponse

data class LoginResponseDto(
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Int,
    val refreshToken: String,
    val scope: String,
    val createdAT: Int
)

fun LoginResponseDto.toDomain(): LoginResponse = LoginResponse(
    accessToken, tokenType, expiresIn, refreshToken, scope, createdAT
)

