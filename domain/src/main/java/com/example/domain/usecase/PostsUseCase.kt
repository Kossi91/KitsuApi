package com.example.domain.usecase

import com.example.domain.repostories.PostRepository

class PostsUseCase(
    private val repository: PostRepository
) {
    operator fun invoke() = repository.fetchPosts()
}