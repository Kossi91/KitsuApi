package com.example.kitsuapi.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kitsuapi.databinding.ItemLoadingBinding
/**
 * [DefaultLoadStateAdapter] DefaultLoadStateAdapter используется для отображения
 * состояния загрузки в RecyclerView.
 */
class DefaultLoadStateAdapter(
) : LoadStateAdapter<DefaultLoadStateAdapter.DefaultLoadStateHolder>() {

    override fun onBindViewHolder(holder: DefaultLoadStateHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): DefaultLoadStateHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLoadingBinding.inflate(inflater, parent, false)
        return DefaultLoadStateHolder(binding)
    }

    inner class DefaultLoadStateHolder(
        private val binding: ItemLoadingBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) = with(binding) {
            progressBar.isVisible = loadState is LoadState.Loading
        }
    }
}