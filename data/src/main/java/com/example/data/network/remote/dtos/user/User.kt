package com.example.data.network.remote.dtos.user

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("data")
                val data: List<DataItem>?,
                @SerializedName("links")
                val links: Links)