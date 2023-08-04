package com.example.kitsuapi.presentation.ui.fragments.anime

import androidx.lifecycle.viewModelScope
import com.example.domain.either.Either
import com.example.domain.usecase.AnimeUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.anime.AnimeUI
import com.example.kitsuapi.presentation.models.anime.toUI
import com.example.kitsuapi.presentation.ui.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AmineViewModel @Inject constructor(
    private val fetchAnimeUseCase: AnimeUseCase
) : BaseViewModel() {

    private val _countriesState =
        MutableStateFlow<UIState<List<AnimeUI>>>(UIState.Loading())
    val countriesState = _countriesState.asStateFlow()


    init {
        fetchAnimeById()
    }

    private fun fetchAnimeById() {
        viewModelScope.launch {
            fetchAnimeUseCase(10, 10).collect { it ->
                when (it) {
                    is Either.Left -> {
                        it.message?.let {
                            _countriesState.value = UIState.Error(it)
                        }
                    }
                    is Either.Right -> {
                        it.data?.let {anime ->
                            _countriesState.value = UIState.Success(anime.map {it.toUI()})
                        }
                    }
                }
            }
        }
    }
}