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

/**
 * [UserFragment] UsersFragment наследуется от [BaseFragment], который содержит общую
 * логику для фрагментов в приложении и представляет собой фрагмент
 * отображающий список пользователей
 * @author Aziz
 * @since 1.0v
 */
class UserFragment : BaseFragment<FragmentUserBinding>(R.layout.fragment_user) {

    override val binding by viewBinding(FragmentUserBinding::bind)
    private val viewModel by viewModel<UserViewModel>()
    private val userAdapter = UserAdapter()

    /**
     * [initialize] используется для инициализации элементов пользовательского интерфейса.
     */
    override fun initialize() {
        setupRecycler()
    }
    /**
     * [setupObserves] подписывается на flow и обновляет
     * [UserAdapter] при получении новых данных.
     */
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
    /**
     * [setupRecycler] настраивает RecyclerView с помощью адаптера.
     */
    private fun setupRecycler() {
        binding.recyclerView.adapter = userAdapter
    }
}