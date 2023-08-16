package com.example.kitsuapi.presentation.models.auth

import com.example.domain.models.auth.LoginResponse

data class LoginResponseUI(
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Int,
    val refreshToken: String,
    val scope: String,
    val createdAT: Int
)

fun LoginResponse.toUI(): LoginResponseUI = LoginResponseUI(
    accessToken, tokenType, expiresIn, refreshToken, scope, createdAT
)