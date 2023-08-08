package com.example.kitsuapi.presentation.ui.fragments.anime

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentAmineBinding
import com.example.kitsuapi.presentation.base.BaseFragment
import com.example.kitsuapi.presentation.extensions.showText
import com.example.kitsuapi.presentation.ui.adapters.AnimeAdapter
import com.example.kitsuapi.presentation.ui.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AmineFragments : BaseFragment<FragmentAmineBinding>(R.layout.fragment_amine) {

    override val binding by viewBinding(FragmentAmineBinding::bind)
    private val viewModel: AmineViewModel by viewModels()
    private val animeAdapter = AnimeAdapter()

    override fun initialize() {
        setupRecycler()
    }

    override fun setupObserves() {
        subscribeToAnime()
    }

    override fun setupRequest() {
        viewModel.fetchAnime()
    }

    private fun setupRecycler() {
        binding.recyclerView.adapter = animeAdapter
    }

    private fun subscribeToAnime() {
        viewModel.countriesState.collectPaging {
            animeAdapter.submitData(it)
        }
    }
}
