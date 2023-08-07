package com.example.kitsuapi.presentation.ui.fragments.manga

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentMangaBinding
import com.example.kitsuapi.presentation.base.BaseFragment
import com.example.kitsuapi.presentation.extensions.showText
import com.example.kitsuapi.presentation.ui.adapters.MangaAdapter
import com.example.kitsuapi.presentation.ui.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    private val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter()

    override fun initialize() {
        setupRecycler()
    }

    override fun setupObserves() {
        subscribeToManga()
    }

    private fun setupRecycler() {
        binding.recyclerView.adapter = mangaAdapter
    }

    private fun subscribeToManga() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.countriesState.collect {
                    when (it) {
                        is UIState.Idle -> {

                        }

                        is UIState.Error -> {
                            showText("Error")
                            Log.e("ERROR" , it.error )
                        }

                        is UIState.Loading -> {
                            binding.progressBar.isVisible = true
                        }

                        is UIState.Success -> {
                            showText("Success")
                            binding.progressBar.isVisible = false
                            mangaAdapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }
}