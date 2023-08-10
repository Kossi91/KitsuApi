package com.example.kitsuapi.presentation.models.auth

import com.example.domain.models.auth.TokenModel


data class TokenModelUI(
    val accessToken: String,
    val refreshToken: String,
)

fun TokenModel.toUI(): TokenModelUI = TokenModelUI(
    accessToken, refreshToken
)
