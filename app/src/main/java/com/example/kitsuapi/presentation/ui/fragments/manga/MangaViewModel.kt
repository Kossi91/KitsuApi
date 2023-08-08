package com.example.kitsuapi.presentation.ui.fragments.manga

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.domain.either.Either
import com.example.domain.repostories.MangaRepository
import com.example.domain.usecase.MangaUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.anime.AnimeUI
import com.example.kitsuapi.presentation.models.anime.toUI
import com.example.kitsuapi.presentation.models.manga.MangaUI
import com.example.kitsuapi.presentation.models.manga.toUI
import com.example.kitsuapi.presentation.ui.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repository: MangaRepository
) : BaseViewModel() {

    private val _countriesState =
        mutableStateWithPagingFlow<MangaUI>()
    val countriesState = _countriesState.asStateFlow()

    fun fetchManga() {
        viewModelScope.launch {
            repository.fetchManga().cachedIn(viewModelScope)
                .collectLatest { it ->
                    _countriesState.value = it.map {
                        it.toUI()
                    }
                }
        }
    }
}