package com.example.kitsuapi.presentation.ui.fragments.manga

import androidx.lifecycle.viewModelScope
import com.example.domain.either.Either
import com.example.domain.usecase.MangaUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.manga.MangaUI
import com.example.kitsuapi.presentation.models.manga.toUI
import com.example.kitsuapi.presentation.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MangaViewModel @Inject constructor (
    private val fetchMangaUseCase: MangaUseCase
) : BaseViewModel() {

    private val _countriesState =
        MutableStateFlow<UIState<List<MangaUI>>>(UIState.Loading())
    val countriesState = _countriesState.asStateFlow()


    init {
        fetchMangaById()
    }

    private fun fetchMangaById() {
        viewModelScope.launch {
            fetchMangaUseCase(10, 10).collect { it ->
                when (it) {
                    is Either.Left -> {
                        it.message?.let {
                            _countriesState.value = UIState.Error(it)
                        }
                    }
                    is Either.Right -> {
                        it.data?.let {manga ->
                            _countriesState.value = UIState.Success(manga.map {it.toUI()})
                        }
                    }
                }
            }
        }
    }
}