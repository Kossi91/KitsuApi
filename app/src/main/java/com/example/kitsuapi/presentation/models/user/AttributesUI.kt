package com.example.kitsuapi.presentation.models.user

import com.example.domain.models.user.Attributes

data class AttributesUI(
    val avatar: AvatarUI? = null,
    val name: String = "",
)
fun Attributes.toUI(): AttributesUI = AttributesUI(
    avatar?.toUI(), name
)