package com.example.kitsuapi.presentation.extensions

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.kitsuapi.R
/**
[activityNavController] activityNavController это navController MainActivity
 * который поможет нам навигировать между FlowFragment'ами
 */
fun Fragment.activityNavController() = requireActivity().findNavController(R.id.nav_host_fragment)
/**
[navigateSafely] extension для безопасной навигации
 */
fun NavController.navigateSafely(@IdRes actionId: Int) {
    currentDestination?.getAction(actionId)?.let { navigate(actionId) }
}
fun NavController.navigateSafe(directions: NavDirections) {
    currentDestination?.getAction(directions.actionId)?.let { navigate(directions) }
}