package com.example.domain.models.user


data class UserResponce(
    val data: List<User>,
    val links: Links
)

data class UserResponse(
    val data: User
)