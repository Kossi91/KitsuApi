package com.example.kitsuapi.presentation.ui.fragments.manga

import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentMangaBinding
import com.example.kitsuapi.databinding.ItemFilterBinding
import com.example.kitsuapi.presentation.base.BaseFragment
import com.example.kitsuapi.presentation.extensions.showText
import com.example.kitsuapi.presentation.models.categories.DataItemCtUI
import com.example.kitsuapi.presentation.models.manga.toUI
import com.example.kitsuapi.presentation.ui.adapters.CategoriesAdapter
import com.example.kitsuapi.presentation.ui.adapters.DefaultLoadStateAdapter
import com.example.kitsuapi.presentation.ui.adapters.MangaAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MangaFragment : BaseFragment<FragmentMangaBinding>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    private val viewModel by viewModel<MangaViewModel>()
    private val mangaAdapter = MangaAdapter()
    private val categoriesList = arrayListOf<DataItemCtUI>()
    private val categoriesAdapter: CategoriesAdapter by lazy {
        CategoriesAdapter(categoriesList)
    }

    override fun initialize() {
        setupRecycler()

        mangaAdapter.addLoadStateListener { state ->
            binding.progressBar.isVisible = state.source.refresh is LoadState.Loading
        }
    }

    override fun setupListener() {
        binding.btnFilter.setOnClickListener {
            showBottomSheet()
        }
    }

    override fun setupObserves() {
        subscribeToManga()
        subscribeToCategories()
        binding.etSearch.addTextChangedListener {
            viewModel.search(it.toString())
        }
    }

    private fun subscribeToManga() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.mangaFlow.collectLatest { pagingData ->
                mangaAdapter.submitData(pagingData.map { it.toUI() })
            }
        }
    }

    private fun subscribeToCategories() {
        viewModel.getCategoriesState.spectateUiState(
            success = { data -> categoriesAdapter.submitData(data) },
            error = { showText(it) }

        )
    }

    private fun setupRecycler() {
        binding.recyclerView.apply {
            adapter = mangaAdapter.withLoadStateFooter(DefaultLoadStateAdapter())
        }
    }
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
