package com.example.kitsuapi.presentation.ui.fragments.user

import androidx.lifecycle.viewModelScope
import com.example.domain.either.Either
import com.example.domain.usecase.UserUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.user.UserUI
import com.example.kitsuapi.presentation.models.user.toUI
import com.example.kitsuapi.presentation.ui.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val fetchUserUseCase: UserUseCase
): BaseViewModel() {

    private val _countriesState =
        MutableStateFlow<UIState<List<UserUI>>>(UIState.Loading())
    val countriesState = _countriesState.asStateFlow()

    init {
        fetchUser()
    }

    private fun fetchUser() {
        viewModelScope.launch {
            fetchUserUseCase().collect { it ->
                when (it) {
                    is Either.Left -> {
                        it.message?.let {
                            _countriesState.value = UIState.Error(it)
                        }
                    }
                    is Either.Right -> {
                        it.data?.let {user ->
                            _countriesState.value = UIState.Success(user.map { it.toUI() })
                        }
                    }
                }
            }
        }
    }
}