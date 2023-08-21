package com.example.kitsuapi.presentation.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentHomeBinding
import com.example.kitsuapi.presentation.ui.adapters.HomeAdapter
import com.google.android.material.tabs.TabLayoutMediator

/**
 * [HomeFragment] Класс MainFragment отвечает за управление
 * главным экраном приложения. Он показывает ViewPager с четырьмя разными вкладками,
 * каждая из которых содержит свой фрагмент.
 * @author Aziz
 * @since 1.0v
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout()
    }
    /**
     * [tabLayout] Добавляет фрагменты и их заголовки в ViewPager.
     */
    private fun tabLayout() = with(binding) {
        viewPager.adapter = HomeAdapter(this@HomeFragment)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = "Anime"
                }

                1 -> {
                    tab.text = "Manga"
                }

                2 -> {
                    tab.text = "User"
                }

                3 -> {
                    tab.text = "Post"
                }
            }
        }
    }.attach()
}