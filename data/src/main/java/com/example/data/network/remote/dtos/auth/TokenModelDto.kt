package com.example.data.network.remote.dtos.auth

import com.example.domain.models.auth.TokenModel
import com.google.gson.annotations.SerializedName

data class TokenModelDto(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
)

fun TokenModelDto.toDomain(): TokenModel = TokenModel(
    accessToken, refreshToken
)
