package com.example.kitsuapi.presentation.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class BaseDiffUtilItemCallback<B : BaseInterfaceCallback> : DiffUtil.ItemCallback<B>() {

    override fun areItemsTheSame(oldItem: B, newItem: B): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: B, newItem: B): Boolean {
        return oldItem == newItem
    }
}