package com.example.kitsuapi.presentation.ui.fragments.createpost

import com.example.domain.usecase.CreatePostUseCase
import com.example.domain.usecase.FetchUserByNameUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.user.UserUI
import com.example.kitsuapi.presentation.models.user.toUI
import kotlinx.coroutines.flow.asStateFlow
/**
 * Класс [CreatePostViewModel] представляет модель представления для [CreatePostFragment].
 * Он содержит два конструкторных параметра: getUserByNameUseCase и createPostUseCase.
 * [FetchUserByNameUseCase] - use case для получения пользователя по имени,
 * [CreatePostUseCase] - это use case для создания поста
 */
class CreatePostViewModel(
    private val fetchUserByNameUseCase: FetchUserByNameUseCase,
    private val createPostUseCase: CreatePostUseCase
) : BaseViewModel() {

    private val _fetchCreatePostState = mutableUIStateFlow<Unit>()
    val fetchCreatePostState = _fetchCreatePostState.asStateFlow()

    private val _userFlow = mutableUIStateFlow<List<UserUI>>()
    val userFlow = _userFlow.asStateFlow()

    /**
     * Функция [getUser] используется для получения пользователя по его имени.
     * Она принимает имя пользователя в качестве аргумента username,
     * затем вызывает [fetchUserByNameUseCase], передавая ему имя пользователя,
     * чтобы получить данные пользователя, которые затем преобразуются в UI-модель
     * и передаются в [gatRequest]. [gatRequest] используется для получения
     * результата операции из [createPostUseCase] и передачи данных в [_fetchCreatePostState].
     */
    fun getUser(username: String) {
        fetchUserByNameUseCase(username).gatRequest(_userFlow) { data -> data.map { it.toUI() } }
    }
    /**
     * Функция [createPost] используется для создания нового поста. Она принимает в качестве
     * параметров идентификатор пользователя userId, содержимое поста content,
     * булевые флаги nsfw и spoiler. Функция вызывает метод createPostUseCase,
     * передавая параметры создания поста. [gatherRequest] используется для получения
     * результата операции из [createPostUseCase] и передачи данных в [_fetchCreatePostState].
     */
    fun createPost(userId: String, content: String, nsfw: Boolean, spoiler: Boolean) {
        createPostUseCase(
            userId = userId, content = content,
            nsfw = nsfw, spoiler = spoiler
        ).gatherRequest(_fetchCreatePostState)
    }
}

