package com.example.kitsuapi.presentation.ui.fragments.anime

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.data.network.repostories.AnimeRepositoryImpl
import com.example.domain.either.Either
import com.example.domain.usecase.AnimeUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.anime.AnimeUI
import com.example.kitsuapi.presentation.models.anime.toUI
import com.example.kitsuapi.presentation.ui.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AmineViewModel @Inject constructor(
    private val repository: AnimeRepositoryImpl
) : BaseViewModel() {

    private val _countriesState =
        mutableStateWithPagingFlow<AnimeUI>()
    val countriesState = _countriesState.asStateFlow()

    fun fetchAnime() {
        viewModelScope.launch {
            repository.fetchAnime().cachedIn(viewModelScope)
                .collectLatest { it ->
                    _countriesState.value = it.map {
                        it.toUI()
                    }
                }
        }
    }
}
