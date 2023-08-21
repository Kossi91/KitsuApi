package com.example.kitsuapi.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

/**
 * [BaseFlowFragment] Абстрактный класс BaseFlowFragment представляет базовый класс flow фрагмента,
 * содержащего NavHostFragment для управления навигацией между фрагментами. Он определяет общую
 * логику настройки NavHostFragment и вызывает функцию setupNavigation, которая может быть
 * переопределена в дочерних классах для настройки конкретной навигации.
 */
abstract class BaseFlowFragment(
    @LayoutRes layoutId: Int,
    @IdRes private val navHostFragmentId: Int
) : Fragment(layoutId) {

    /**
     * [onViewCreated] - В этой функции
     * определяется NavHostFragment и связанный с ним NavController, который передается в
     * функцию setupNavigation.
     */

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
        val navController = navHostFragment.navController

        setupNavigation(navController)
    }
    /**
     * [setupNavigation] - открытая функция, которая вызывается из onViewCreated
     * и может быть переопределена в дочерних классах для настройки конкретной навигации
     */
    protected open fun setupNavigation(navController: NavController) {
    }
}