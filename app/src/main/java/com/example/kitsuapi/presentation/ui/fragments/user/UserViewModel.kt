package com.example.kitsuapi.presentation.ui.fragments.user

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.domain.either.Either
import com.example.domain.repostories.UserRepository
import com.example.domain.usecase.UserUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.user.UserUI
import com.example.kitsuapi.presentation.models.user.toUI
import com.example.kitsuapi.presentation.ui.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : BaseViewModel() {

    private val _countriesState =
        mutableStateWithPagingFlow<UserUI>()
    val countriesState = _countriesState.asStateFlow()


    fun fetchUser() {
        viewModelScope.launch {
            repository.fetchUser().cachedIn(viewModelScope)
                .collectLatest {it->
                    _countriesState.value = it.map {
                        it.toUI()
                    }
                }
        }
    }
}