package com.example.kitsuapi.presentation.models.auth


data class AuthModelUI(
    val grant_type: String = "password",
    val email: String,
    val password: String
)
