package com.example.kitsuapi.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import androidx.viewbinding.ViewBinding
import com.example.kitsuapi.presentation.ui.state.UIState
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * [BaseFragment] Абстрактный класс BaseFragment является базовым классом для всех фрагментов
 * в приложении и содержит общую логику, которую можно переопределить в наследниках.
 */
abstract class BaseFragment<VB: ViewBinding> (@LayoutRes layoutId: Int) : Fragment(layoutId) {

    protected abstract val binding : VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupViews()
        setupListener()
        setupRequest()
        setupObserves()
    }

    /**
     * [initialize] метод, который вызывается при создании фрагмента и может быть переопределен
     * в наследниках, чтобы инициализировать какие-либо необходимые данные или переменные.
     */
    protected open fun initialize(){}

    protected open fun setupViews(){}

    /**
     * [setupListeners] метод, который вызывается после установки запросов и может быть переопределен
     * в наследниках, чтобы установить слушатели для каких-либо View или других элементов
     * пользовательского интерфейса.
     */
    protected open fun setupListener(){}
    /**
     * [setupRequest] метод, который вызывается после инициализации и может быть переопределен в
     * наследниках, чтобы установить какие-либо запросы к серверу или базе данных.
     */
    protected open fun setupRequest(){}

    /**
     * [setupObserves] setupObserves() - метод, который вызывается после установки слушателей
     * и может быть переопределен в наследниках, чтобы установить наблюдателей за данными,
     * получаемыми из ViewModel или других источников.
     */
    protected open fun setupObserves(){}

    protected fun <T> StateFlow<UIState<T>>.collectUIState(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        collector: FlowCollector<UIState<T>>
    ) {
        collectFlowSafely(lifecycleState) { this.collect(collector) }
    }

    protected fun <T : Any> StateFlow<PagingData<T>?>.collectPaging(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        action: suspend (value: PagingData<T>) -> Unit
    ) {
        collectFlowSafely(lifecycleState) { this.collectLatest { it?.let { action(it) } } }
    }

    private fun collectFlowSafely(
        lifecycleState: Lifecycle.State,
        collect: suspend () -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(lifecycleState) {
                collect()
            }
        }
    }

    protected fun <T> StateFlow<UIState<T>>.spectateUiState(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        success: ((data: T) -> Unit)? = null,
        loading: ((data: UIState.Loading<T>) -> Unit)? = null,
        error: ((error: String) -> Unit)? = null,
        idle: ((idle: UIState.Idle<T>) -> Unit)? = null,
        gatherIfSucceed: ((state: UIState<T>) -> Unit)? = null,
    ) {
        collectFlowSafely(lifecycleState) {
            collect {
                gatherIfSucceed?.invoke(it)
                when (it) {
                    is UIState.Idle -> {
                        idle?.invoke(it)
                    }
                    is UIState.Loading -> {
                        loading?.invoke(it)
                    }
                    is UIState.Error -> {
                        error?.invoke(it.error)
                    }
                    is UIState.Success -> {
                        success?.invoke(it.data)
                    }
                }
            }
        }
    }
}