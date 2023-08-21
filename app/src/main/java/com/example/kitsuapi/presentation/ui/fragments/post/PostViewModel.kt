package com.example.kitsuapi.presentation.ui.fragments.post

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.models.post.DataItem
import com.example.domain.models.user.User
import com.example.domain.usecase.FetchUserByPostIdUseCase
import com.example.domain.usecase.PostsUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.Flow

/**
 * Класс [PostViewModel] представляет viewModel для [PostViewModel], который содержит две зависимости
 * - getPostsUseCase и getUserByPostIdUseCase. Он также наследует класс [BaseViewModel].
 */
class PostViewModel(
    private val postsUseCase: PostsUseCase,
    private val fetchUserByPostIdUseCase: FetchUserByPostIdUseCase
) : BaseViewModel() {

    /**
     * Возвращает пользователя, по id поста.
     */
    suspend fun fetchUser(id: String): User {
        return fetchUserByPostIdUseCase(id)
    }
    /**
     * [postsFlow] Возвращает объект Flow<PagingData<PostsData>>, который содержит данные о постах.
     */
    val postsFlow: Flow<PagingData<DataItem>> = postsUseCase().cachedIn(viewModelScope)
}
