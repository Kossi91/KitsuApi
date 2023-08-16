package com.example.kitsuapi.presentation.ui.fragments.user

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.domain.repostories.UserRepository
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.user.UserUI
import com.example.kitsuapi.presentation.models.user.toUI
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModel(
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