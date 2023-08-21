package com.example.kitsuapi.presentation.ui.fragments.anime

import android.util.Log
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentAmineBinding
import com.example.kitsuapi.databinding.ItemFilterBinding
import com.example.kitsuapi.presentation.base.BaseFragment
import com.example.kitsuapi.presentation.extensions.showText
import com.example.kitsuapi.presentation.models.anime.toUI
import com.example.kitsuapi.presentation.models.categories.DataItemCtUI
import com.example.kitsuapi.presentation.ui.adapters.AnimeAdapter
import com.example.kitsuapi.presentation.ui.adapters.CategoriesAdapter
import com.example.kitsuapi.presentation.ui.adapters.DefaultLoadStateAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
/**
 * [AmineFragments] AnimeFragment наследуется от [BaseFragment], который содержит общую
 * логику для фрагментов в приложении и представляет собой фрагмент,
 * отображающий список аниме c возможностью фильтрации по категориям и поиска.
 * @author Aziz
 * @since 1.0v
 */

class AmineFragments : BaseFragment<FragmentAmineBinding>(R.layout.fragment_amine) {

    override val binding by viewBinding(FragmentAmineBinding::bind)
    private val viewModel by viewModel<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter()
    private val categoriesList = arrayListOf<DataItemCtUI>()
    private val categoriesAdapter: CategoriesAdapter by lazy {
        CategoriesAdapter(categoriesList)
    }

    /**
     * [initialize] используется для инициализации элементов пользовательского интерфейса.
     */
    override fun initialize() {
        setupRecycler()

        animeAdapter.addLoadStateListener { state ->
            binding.progressBar.isVisible = state.source.refresh is LoadState.Loading
        }
    }

    /**
     * [setupListener] используется чтобы установить слушатели для каких-либо View или
     * других элементов пользовательского интерфейса.
     */
    override fun setupListener() {
        binding.btnFilter.setOnClickListener {
            showBottomSheet()
        }
    }
    /**
     * [setupObserves] метод для наблюдания за данными,
     * получаемыми из ViewModel.
     */
    override fun setupObserves() {
        subscribeToAnime()
        subscribeToCategories()
        binding.etSearch.addTextChangedListener {
            viewModel.search(it.toString())
        }
    }

    /**
     * [subscribeToAnime] подписывается на flow и обновляет
     * [AnimeAdapter] при получении новых данных.
     */
    private fun subscribeToAnime() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.animeFlow.collectLatest { pagingData ->
                animeAdapter.submitData(pagingData.map { it.toUI() })
            }
        }
    }
    /**
     * [subscribeToCategories] подписывается на Flow,
     * разворачивая его из [com.example.kitsuapi.presentation.ui.UIState]
     */
    private fun subscribeToCategories() {
        viewModel.getCategoriesState.spectateUiState(
            success = { data -> categoriesAdapter.submitData(data) },
            error = { showText(it)
            Log.e("ERROR",it)}

        )
    }
    /**
     * [setupRecycler] настраивает RecyclerView с помощью LayoutManager и адаптера.
     */
    private fun setupRecycler() {
        binding.recyclerView.apply {
            adapter = animeAdapter.withLoadStateFooter(DefaultLoadStateAdapter())
        }
    }

    /**
     * [showBottomSheet] используется для отображения BottomSheet для фильтрации списка
     * манга по категориям. Здесь мы создаем экземпляр BsFilterBinding для настройки
     * макета BottomSheet. Затем мы настраиваем RecyclerView для отображения списка категорий
     * и устанавливаем слушатели для кнопок "Применить" и "Сбросить". После этого мы
     * устанавливаем макет BsFilterBinding в качестве содержимого BottomSheet и отображаем его.
     * Автоматически при инициализации viewmodel происходит запрос на категории
     * и хранятся в [categoriesList]
     */
    private fun showBottomSheet() {
        val filerBinding = ItemFilterBinding.inflate(layoutInflater)
        val bottomSheet = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)

        filerBinding.rvCategoriesAnime.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = categoriesAdapter
        }

        filerBinding.btnApply.setOnClickListener {
            viewModel.filter(categoriesAdapter.getSelectedItems())
            bottomSheet.dismiss()
        }

        filerBinding.btnReset.setOnClickListener {
            viewModel.filter(emptyList())
            categoriesAdapter.clearSelectedItems()
            bottomSheet.dismiss()
        }

        bottomSheet.setContentView(filerBinding.root)
        bottomSheet.show()
    }
}
