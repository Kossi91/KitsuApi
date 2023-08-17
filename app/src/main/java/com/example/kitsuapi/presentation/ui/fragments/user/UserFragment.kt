package com.example.kitsuapi.presentation.ui.fragments.user

import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentUserBinding
import com.example.kitsuapi.presentation.base.BaseFragment
import com.example.kitsuapi.presentation.models.user.toUI
import com.example.kitsuapi.presentation.ui.adapters.UserAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment<FragmentUserBinding>(R.layout.fragment_user) {

    override val binding by viewBinding(FragmentUserBinding::bind)
    private val viewModel by viewModel<UserViewModel>()
    private val userAdapter = UserAdapter()

    override fun initialize() {
        setupRecycler()
    }

    override fun setupObserves() {
        setupRequest()
    }
    override fun setupRequest() {
        viewLifecycleOwner.lifecycleScope.launch{
            viewModel.usersFlow.collectLatest {userData->
                userAdapter.submitData(userData.map { it.toUI() })
            }
        }
    }
    private fun setupRecycler() {
        binding.recyclerView.adapter = userAdapter
    }
}