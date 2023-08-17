package com.example.kitsuapi.presentation.ui.fragments.user

import androidx.paging.PagingData
import com.example.domain.models.user.User
import com.example.domain.usecase.UserUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModel(
    private val userUseCase: UserUseCase
) : BaseViewModel() {

    val usersFlow: Flow<PagingData<User>> = userUseCase.invoke()

    init {
        usersFlow.flatMapLatest {
            userUseCase.invoke()
        }
    }
}