package com.example.kitsuapi.presentation.ui.fragments.anime

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.models.anime.Anime
import com.example.domain.usecase.AnimeUseCase
import com.example.domain.usecase.CategoriesUseCase
import com.example.kitsuapi.presentation.base.BaseViewModel
import com.example.kitsuapi.presentation.models.categories.DataItemCtUI
import com.example.kitsuapi.presentation.models.categories.toUI
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.*
/**
 * Класс [AnimeViewModel] представляет viewModel для [AnimeFragment]. Он принимает
 * два UseCase-класса: [animeUseCase] для получения списка аниме и [categoriesUseCase]
 * для получения списка категорий.
 */
@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
class AnimeViewModel(
    private val animeUseCase: AnimeUseCase,
    private val categoriesUseCase: CategoriesUseCase
) : BaseViewModel() {

    val animeFlow: Flow<PagingData<Anime>>

    /**
     * AnimeViewModel имеет два MutableStateFlow поля: [search] и [filter], которые используются
     * для поиска и фильтрации аниме соответственно. Эти поля изменяются через
     * методы [search] и [filter].
     * Кроме того, класс имеет Flow<PagingData<Data>> поле [animeFlow], которое используется
     * для передачи списка аниме в пользовательский интерфейс. При изменении поля searchBy
     * или filterBy animeFlow перезапрашивается с помощью метода getAnimeUseCase.invoke().
     */
    private val search = MutableStateFlow("")
    private val filter = MutableStateFlow<List<String>>(emptyList())

    /**
     * Класс также имеет поле [categoriesUseCase], которое содержит список категорий аниме,
     * полученный с помощью метода [categoriesUseCase].
     */
    private val _getCategoriesState = mutableUIStateFlow<List<DataItemCtUI>>()
    val getCategoriesState = _getCategoriesState.asStateFlow()

    /**
     * В блоке инициализации класса [AnimeViewModel] происходит инициализация полей [animeFlow]
     * и [getCategoriesState].
     * [animeFlow] использует метод [combine] для комбинации двух MutableStateFlow полей:
     * [search] и [filter].Затем метод [flatMapLatest] вызывается на результате combine(),
     * чтобы получить новый Flow,который содержит список manga. Если поле [search] пустое,
     * то вызывается метод getAnimeUseCase.invoke() с параметром null так как если отправить
     * пустой аргумент для фильтрации приходит пустой список, иначе вызывается
     * с параметром [search]. Результат вызова метода [debounce] используется для
     * предотвращения отправки слишком частых запросов при поиске если пользователь
     * быстро печатает, а cachedIn(viewModelScope)
     * используется для сохранения результата запроса в кэше.
     */
    /**
     * [categoriesUseCase] использует метод [gatRequest] для вызова метода getCategoriesUseCase()
     * и получения списка категорий. Результат вызова метода map() используется для преобразования
     * полученных данных в модельку для UI слоя. Преобразованный список передается в
     * _getCategoriesState, который также используется для
     * передачи списка в пользовательский интерфейс.
     */

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

    /**
     * [search] Метод для передачи аргументов поиска
     */

    fun search(value: String?) {
        if (search.value == value) return
        if (value != null) {
            search.value = value
        }
    }

    /**
     * [filter] Метод для передачи аргументов поиска.
     */
    fun filter(value: List<String>?) {
        if (this.filter.value == value) return
        if (value != null) {
            this.filter.value = value
        }
    }
}





