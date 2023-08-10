package com.example.kitsuapi.presentation.ui.fragments.anime

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.data.network.repostories.AnimeRepositoryImpl
import com.example.domain.models.anime.Anime
import com.example.domain.usecase.AnimeUseCase
import com.example.domain.usecase.CategoriesUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.anime.AnimeUI
import com.example.kitsuapi.presentation.models.anime.toUI
import com.example.kitsuapi.presentation.models.categories.DataItemCtUI
import com.example.kitsuapi.presentation.models.categories.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AmineViewModel @Inject constructor(
    private val repository: AnimeRepositoryImpl,
    private val categoriesUseCase: CategoriesUseCase,
    private val animeUseCase: AnimeUseCase
) : BaseViewModel() {

    val animeFlow: Flow<PagingData<Anime>>

    private val search = MutableStateFlow("")
    private val filter = MutableStateFlow<List<String>>(emptyList())

//    private val _countriesState =
//        mutableStateWithPagingFlow<AnimeUI>()
//    val countriesState = _countriesState.asStateFlow()
//

    private val _getCategoriesState = mutableUIStateFlow<List<DataItemCtUI>>()
    val getCategoriesState = _getCategoriesState.asStateFlow()

//    fun fetchAnime() {
//        viewModelScope.launch {
//            repository.fetchAnime().cachedIn(viewModelScope)
//                .collectLatest { it ->
//                    _countriesState.value = it.map {
//                        it.toUI()
//                    }
//                }
//        }
//    }

    init {
        animeFlow = combine(search, filter) { search, filter ->
            Pair(search, filter)
        }.flatMapLatest { (search, filter) ->
            if (search.isBlank()) {
                animeUseCase.invoke(null, filter)
                    .debounce(500)
                    .cachedIn(viewModelScope)
            } else {
                animeUseCase.invoke(search, filter)
                    .debounce(500)
                    .cachedIn(viewModelScope)
            }
        }
        categoriesUseCase().gatRequest(_getCategoriesState){
            it.map { it.toUI() }
        }
    }

    fun search(value: String?) {
        if (search.value == value) return
        if (value != null) {
            search.value = value
        }
    }

    fun filter(value: List<String>?) {
        if (this.filter.value == value) return
        if (value != null) {
            this.filter.value = value
        }
    }
}





