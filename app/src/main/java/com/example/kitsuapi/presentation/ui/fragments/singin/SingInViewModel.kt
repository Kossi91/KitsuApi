package com.example.kitsuapi.presentation.ui.fragments.singin

import com.example.domain.usecase.SingInUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.auth.LoginResponseUI
import com.example.kitsuapi.presentation.models.auth.toUI
import kotlinx.coroutines.flow.asStateFlow

class SingInViewModel (
    private val singInUseCase: SingInUseCase
) : BaseViewModel() {

    private val _getLoginState = mutableUIStateFlow<LoginResponseUI>()
    val getLoginState = _getLoginState.asStateFlow()

    fun login(email: String, password: String) {
        singInUseCase(
            email = email,
            password = password
        ).gatRequest(_getLoginState) { it.toUI() }
    }
}