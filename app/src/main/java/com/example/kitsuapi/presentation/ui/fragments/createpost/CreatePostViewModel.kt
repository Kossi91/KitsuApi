package com.example.kitsuapi.presentation.ui.fragments.createpost

import com.example.domain.usecase.CreatePostUseCase
import com.example.domain.usecase.FetchUserByNameUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.user.UserUI
import com.example.kitsuapi.presentation.models.user.toUI
import kotlinx.coroutines.flow.asStateFlow

class CreatePostViewModel(
    private val fetchUserByNameUseCase: FetchUserByNameUseCase,
    private val createPostUseCase: CreatePostUseCase
) : BaseViewModel() {

    private val _fetchCreatePostState = mutableUIStateFlow<Unit>()
    val fetchCreatePostState = _fetchCreatePostState.asStateFlow()

    private val _userFlow = mutableUIStateFlow<List<UserUI>>()
    val userFlow = _userFlow.asStateFlow()

    fun getUser(username: String) {
        fetchUserByNameUseCase(username).gatRequest(_userFlow) { data -> data.map { it.toUI() } }
    }

    fun createPost(userId: String, content: String, nsfw: Boolean, spoiler: Boolean) {
        createPostUseCase(
            userId = userId, content = content,
            nsfw = nsfw, spoiler = spoiler
        ).gatherRequest(_fetchCreatePostState)
    }
}

