package com.example.domain.models.auth


data class TokenModel(
    val accessToken: String,
    val refreshToken: String,
)
