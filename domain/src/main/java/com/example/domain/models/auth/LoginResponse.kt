package com.example.domain.models.auth

data class LoginResponse(
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Int,
    val refreshToken: String,
    val scope: String,
    val createdAT: Int
)