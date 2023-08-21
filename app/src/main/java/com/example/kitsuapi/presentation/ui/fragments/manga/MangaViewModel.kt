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
import com.example.kitsuapi.presentation.ui.fragments.anime.AnimeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
/**
 * Класс [MangaViewModel] представляет viewModel для [MangaFragment]. Он принимает
 * два UseCase-класса: [mangaUseCase] для получения списка аниме и [categoriesUseCase]
 * для получения списка категорий.
 */
@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
class MangaViewModel (
    private val categoriesUseCase: CategoriesUseCase,
    private val mangaUseCase: MangaUseCase
) : BaseViewModel() {
    /**
     * MangaViewModel имеет два MutableStateFlow поля: [search] и [filter], которые используются
     * для поиска и фильтрации аниме соответственно. Эти поля изменяются через
     * методы [search] и [filter].
     * Кроме того, класс имеет Flow<PagingData<Data>> поле [mangaFlow], которое используется
     * для передачи списка аниме в пользовательский интерфейс. При изменении поля searchBy
     * или filterBy animeFlow перезапрашивается с помощью метода getAnimeUseCase.invoke().
     */
    val mangaFlow: Flow<PagingData<Manga>>

    private val search = MutableStateFlow("")
    private val filter = MutableStateFlow<List<String>>(emptyList())
    /**
     * Класс также имеет поле [categoriesUseCase], которое содержит список категорий аниме,
     * полученный с помощью метода [categoriesUseCase].
     */
    private val _getCategoriesState = mutableUIStateFlow<List<DataItemCtUI>>()
    val getCategoriesState = _getCategoriesState.asStateFlow()

    /**
     * В блоке инициализации класса [MangaViewModel] происходит инициализация полей [mangaFlow]
     * и [getCategoriesState].
     * [mangaFlow] использует метод [combine] для комбинации двух MutableStateFlow полей:
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