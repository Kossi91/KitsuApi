package com.example.kitsuapi.presentation.ui.fragments.manga

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.models.manga.Manga
import com.example.domain.usecase.CategoriesUseCase
import com.example.domain.usecase.MangaUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.categories.DataItemCtUI
import com.example.kitsuapi.presentation.models.categories.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase,
    private val mangaUseCase: MangaUseCase
) : BaseViewModel() {

    val mangaFlow: Flow<PagingData<Manga>>

    private val search = MutableStateFlow("")
    private val filter = MutableStateFlow<List<String>>(emptyList())

    private val _getCategoriesState = mutableUIStateFlow<List<DataItemCtUI>>()
    val getCategoriesState = _getCategoriesState.asStateFlow()

    init {
        mangaFlow = combine(search, filter) { search, filter ->
            Pair(search, filter)
        }.flatMapLatest { (search, filter) ->
            if (search.isBlank()) {
                mangaUseCase.invoke(null, filter)
                    .debounce(500)
                    .cachedIn(viewModelScope)
            } else {
                mangaUseCase.invoke(search, filter)
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