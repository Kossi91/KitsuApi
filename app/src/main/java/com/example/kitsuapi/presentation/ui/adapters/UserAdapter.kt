package com.example.kitsuapi.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.ItemUserBinding
import com.example.kitsuapi.presentation.models.user.UserUI

class UserAdapter : PagingDataAdapter<UserUI, UserAdapter.UserViewHolder>(diffUtil) {
    inner class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: UserUI?) {
            if (item?.attributes?.avatar?.original != null) {
                Glide.with(binding.ivImage.context)
                    .load(item.attributes.avatar.original)
                    .into(binding.ivImage)
            }else{
                binding.ivImage.setImageResource(R.drawable.ava)
            }
            binding.tvName.text = item?.attributes?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<UserUI>() {
            override fun areItemsTheSame(oldItem: UserUI, newItem: UserUI): Boolean {
                return oldItem.attributes == newItem.attributes
            }

            override fun areContentsTheSame(oldItem: UserUI, newItem: UserUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}