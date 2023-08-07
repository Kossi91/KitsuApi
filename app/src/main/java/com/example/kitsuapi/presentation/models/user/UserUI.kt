package com.example.kitsuapi.presentation.models.user

import com.example.domain.models.user.User


data class UserUI(
    val attributes: AttributesUI,
    val id: String = "",
)

fun User.toUI(): UserUI = UserUI(
    attributes.toUI(), id
)