package com.example.kitsuapi.presentation.ui.fragments.singin

import android.view.View
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
/**
 * [SingInFragment] Фрагмент для авторизации пользователя
 * @author Aziz
 * @since 1.0v
 */
class SingInFragment
    : BaseFragment<FragmentSingInBinding>(R.layout.fragment_sing_in) {

    private val tokenPreferenceHelper : TokenPreferenceHelper by inject()
    override val binding by viewBinding(FragmentSingInBinding::bind)
    private val viewModel by viewModel<SingInViewModel>()


    override fun initialize() {
        if (!tokenPreferenceHelper.onBoardIsShown) {
            findNavController().navigateSafely(R.id.action_singInFragment_to_boardFragment)
        }
    }
    /**
     * [setupListener] используется чтобы установить слушатели для каких-либо View или
     * других элементов пользовательского интерфейса.
     */
    override fun setupListener() {
        binding.btmSingin.setOnClickListener {
            singIn()
        }
    }

    /**
     * [setupObserves] метод для наблюдания за данными,
     * получаемыми из ViewModel.
     */
    override fun setupObserves() {
        subscribeToLoginState()
    }
    /**
     * [singIn] Проверяет введенные данные и запускает процесс входа
     */
    private fun singIn() = with(binding) {
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
    /**
     * [subscribeToLoginState] наблюдает за Flow,
     * разворачивая его из [com.example.kitsuapi.presentation.ui.UIState]
     */
    private fun subscribeToLoginState() {
        viewModel.getSingInState.spectateUiState(
            loading = {
                binding.progressBar.visibility = View.VISIBLE
            },
            success = {
                onSuccessLogin(it)
            },
            error = {
                binding.progressBar.visibility = View.GONE
            }
        )
    }

    /**
     * Обрабатывает успешный вход в приложение
     */
    private fun onSuccessLogin(loginResponse: LoginResponseUI) {
        showText(getString(R.string.success))
        binding.progressBar.visibility = View.GONE
        tokenPreferenceHelper.accessToken = loginResponse.access_token
        tokenPreferenceHelper.refreshToken = loginResponse.refresh_token
        activityNavController().navigateSafely(R.id.action_global_homeFlowFragment)
    }
}