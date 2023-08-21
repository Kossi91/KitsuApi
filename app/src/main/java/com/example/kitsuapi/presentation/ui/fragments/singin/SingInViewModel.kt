package com.example.kitsuapi.presentation.ui.fragments.singin

import com.example.domain.usecase.SingInUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.auth.LoginResponseUI
import com.example.kitsuapi.presentation.models.auth.toUI
import kotlinx.coroutines.flow.asStateFlow

/**
 * Класс [SingInViewModel] представляет viewModel для [SingInFragment]. Он принимает
 * два UseCase-класса: [singInUseCase] для получения списка аниме
 */
class SingInViewModel (
    private val singInUseCase: SingInUseCase
) : BaseViewModel() {
    /**
     * Открытое состояние [_getSingInState] является StateFlow, который является неизменяемым
     * и предоставляет только чтение текущего состояния выполнения запроса на вход в систему.
     */
    private val _getSingInState = mutableUIStateFlow<LoginResponseUI>()
    val getSingInState = _getSingInState.asStateFlow()

    /**
     * Функция [login] используется входа в приложение.
     * Она принимает username и password в качестве аргумента,
     * затем вызывает [getSingInState], передавая ему имя пользователя,
     * чтобы получить данные пользователя, которые затем преобразуются в UI-модель
     * и передаются в [gatRequest]. [gatRequest] используется для получения
     * результата операции из [getSingInState] и передачи данных в [_getSingInState].
     */
    fun login(email: String, password: String) {
        singInUseCase(
            email = email,
            password = password
        ).gatRequest(_getSingInState) { it.toUI() }
    }
}