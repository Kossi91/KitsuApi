package com.example.kitsuapi.presentation.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kitsuapi.presentation.ui.fragments.anime.AmineFragments
import com.example.kitsuapi.presentation.ui.fragments.manga.MangaFragment

class HomeAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                AmineFragments()
            }

            else -> MangaFragment()
        }
    }
}