package com.example.kitsuapi.presentation.ui.fragments.user

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentUserBinding
import com.example.kitsuapi.presentation.base.BaseFragment
import com.example.kitsuapi.presentation.extensions.showText
import com.example.kitsuapi.presentation.ui.adapters.UserAdapter
import com.example.kitsuapi.presentation.ui.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserBinding>(R.layout.fragment_user) {

    override val binding by viewBinding(FragmentUserBinding::bind)
    private val viewModel: UserViewModel by viewModels()
    private val userAdapter = UserAdapter()

    override fun initialize() {
        setupRecycler()
    }

    override fun setupObserves() {
        subscribeToUser()
    }

    private fun setupRecycler() {
        binding.recyclerView.adapter = userAdapter
    }

    private fun subscribeToUser() {
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
                            userAdapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }
}