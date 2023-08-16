package com.example.kitsuapi.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import com.example.data.local.prefs.TokenPreferenceHelper
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val tokenPreferenceHelper: TokenPreferenceHelper by inject()
    private lateinit var binding: ActivityMainBinding
    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        when {
            tokenPreferenceHelper.accessToken == null -> {
                navGraph.setStartDestination(R.id.singInFlowFragment)
            }

            tokenPreferenceHelper.accessToken != null -> {
                navGraph.setStartDestination(R.id.homeFlowFragment)
            }
        }
        navController.graph = navGraph
    }
}