package com.example.domain.usecase

import com.example.domain.repostories.PostRepository

class CreatePostUseCase(
    private val repository: PostRepository
) {
    operator fun invoke(userId: String, content: String, nsfw: Boolean, spoiler: Boolean) =
        repository.createPost(userId = userId, content = content, nsfw = nsfw, spoiler = spoiler)
}