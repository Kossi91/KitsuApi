package com.example.kitsuapi.presentation.ui.fragments.user

import androidx.paging.PagingData
import com.example.domain.models.user.User
import com.example.domain.usecase.UserUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.Flow
/**
 * Класс [UserViewModel] представляет viewModel для [UserFragment], который содержит логику для получения
 * списка пользователей. Он также наследует класс [BaseViewModel].
 */
@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModel(
    private val userUseCase: UserUseCase
) : BaseViewModel() {
    /**
     * [usersFlow] Возвращает экземпляр Flow<PagingData<User>>, который представляет список
     * пользователей с возможностью постраничной загрузки.
     */
    val usersFlow: Flow<PagingData<User>> = userUseCase.invoke()

    /**
     * [init] блок инициализации [UserViewModel] Инициализирует usersFlow с помощью flatMapLatest,
     * который отслеживает изменения , отправляет запрос на получение пользователей
     */
    init {
        usersFlow.flatMapLatest {
            userUseCase.invoke()
        }
    }
}