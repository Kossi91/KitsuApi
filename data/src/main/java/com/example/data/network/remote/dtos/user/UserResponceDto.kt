package com.example.data.network.remote.dtos.user

import com.google.gson.annotations.SerializedName

data class UserResponceDto<T>(
    @SerializedName("data")
    val data: List<T>,
)
