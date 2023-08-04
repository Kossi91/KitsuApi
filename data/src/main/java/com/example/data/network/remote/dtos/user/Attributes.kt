package com.example.data.network.remote.dtos.user

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("birthday")
    val birthday: String = "",
    @SerializedName("gender")
    val gender: String = "",
    @SerializedName("feedCompleted")
    val feedCompleted: Boolean = false,
    @SerializedName("likesReceivedCount")
    val likesReceivedCount: Int = 0,
    @SerializedName("about")
    val about: String = "",
    @SerializedName("subscribedToNewsletter")
    val subscribedToNewsletter: Boolean = false,
    @SerializedName("reviewsCount")
    val reviewsCount: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("followingCount")
    val followingCount: Int = 0,
    @SerializedName("createdAt")
    val createdAt: String = "",
    @SerializedName("lifeSpentOnAnime")
    val lifeSpentOnAnime: Int = 0,
    @SerializedName("postsCount")
    val postsCount: Int = 0,
    @SerializedName("permissions")
    val permissions: String = "",
    @SerializedName("coverImage")
    val coverImage: String = "",
    @SerializedName("ratingsCount")
    val ratingsCount: Int = 0,
    @SerializedName("updatedAt")
    val updatedAt: String = "",
    @SerializedName("likesGivenCount")
    val likesGivenCount: Int = 0,
    @SerializedName("profileCompleted")
    val profileCompleted: Boolean = false,
    @SerializedName("avatar")
    val avatar: String = "",
    @SerializedName("favoritesCount")
    val favoritesCount: Int = 0,
    @SerializedName("commentsCount")
    val commentsCount: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("mediaReactionsCount")
    val mediaReactionsCount: Int = 0,
    @SerializedName("sfwFilterPreference")
    val sfwFilterPreference: String = "",
    @SerializedName("followersCount")
    val followersCount: Int = 0,
    @SerializedName("status")
    val status: String = ""
)