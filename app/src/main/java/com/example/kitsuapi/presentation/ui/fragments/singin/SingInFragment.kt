package com.example.kitsuapi.presentation.ui.fragments.singin

import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.local.prefs.TokenPreferenceHelper
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentSingInBinding
import com.example.kitsuapi.presentation.base.BaseFragment
import com.example.kitsuapi.presentation.extensions.activityNavController
import com.example.kitsuapi.presentation.extensions.navigateSafely
import com.example.kitsuapi.presentation.extensions.showText
import com.example.kitsuapi.presentation.models.auth.LoginResponseUI
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SingInFragment()
    : BaseFragment<FragmentSingInBinding>(R.layout.fragment_sing_in) {

    private val tokenPreferenceHelper : TokenPreferenceHelper by inject()
    override val binding by viewBinding(FragmentSingInBinding::bind)
    private val viewModel by viewModel<SingInViewModel>()


    override fun initialize() {
        showText("SingIN")
        if (!tokenPreferenceHelper.onBoardIsShown) {
            findNavController().navigateSafely(R.id.action_singInFragment_to_boardFragment)
        }
    }

    override fun setupListener() {
        binding.btmSingin.setOnClickListener {
            SingIn()
        }
    }

    private fun SingIn() = with(binding) {
        if (etEmail.text.isEmpty()) {
            etEmail.error = getString(R.string.enter_email)
        } else if (etPassword.text.isEmpty()) {
            binding.etPassword.error = getString(R.string.enter_password)
        } else {
            viewModel.login(
                email = etEmail.text.toString(),
                password = etPassword.text.toString()
            )
        }
    }

    override fun setupObserves() {
        subscribeToLoginState()
    }

    private fun subscribeToLoginState() {
        viewModel.getLoginState.spectateUiState(
            loading = {
                binding.progressBar.isVisible
            },
            success = {
                onSuccessLogin(it)
            },
            error = {
                binding.progressBar.isInvisible
            }
        )
    }

    private fun onSuccessLogin(loginResponse: LoginResponseUI) {
        showText(getString(R.string.success))
        binding.progressBar.isInvisible
        tokenPreferenceHelper.accessToken = loginResponse.accessToken
        tokenPreferenceHelper.refreshToken = loginResponse.refreshToken
        activityNavController().navigateSafely(R.id.action_global_homeFlowFragment)
    }
}