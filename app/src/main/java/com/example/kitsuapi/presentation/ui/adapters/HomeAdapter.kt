package com.example.kitsuapi.presentation.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kitsuapi.presentation.ui.fragments.anime.AmineFragments
import com.example.kitsuapi.presentation.ui.fragments.manga.MangaFragment
import com.example.kitsuapi.presentation.ui.fragments.post.PostFragment
import com.example.kitsuapi.presentation.ui.fragments.user.UserFragment
/**
 * [HomeAdapter] Класс HomeAdapter представляет собой адаптер для
 * управления списком фрагментов внутри ViewPager. Он
 * предоставляет дополнительные методы для добавления фрагментов и получения заголовков вкладок.
 */
class HomeAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                AmineFragments()
            }

            1 -> {
                MangaFragment()
            }

            2 -> {
                UserFragment()
            }

            else -> PostFragment()
        }
    }
}