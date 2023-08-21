package com.example.kitsuapi.presentation.ui.fragments.home

import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentHomeFlowBinding
import com.example.kitsuapi.presentation.base.BaseFlowFragment

/**
* [HomeFlowFragment] Фрагмент со своим контейнером и графом для навигации в проекте
* @author Aziz
* @since 1.0v
*/
class HomeFlowFragment : BaseFlowFragment(R.layout.fragment_home_flow, R.id.home_host_fragment) {

    private val binding by viewBinding(FragmentHomeFlowBinding::bind)

    override fun setupNavigation(navController: NavController) {
        binding.bottomNavigation.setupWithNavController(navController)
    }
}