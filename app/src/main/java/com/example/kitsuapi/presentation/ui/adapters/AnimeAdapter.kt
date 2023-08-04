package com.example.kitsuapi.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsuapi.databinding.ItemAnimeBinding
import com.example.kitsuapi.presentation.models.anime.AnimeUI

class AnimeAdapter: ListAdapter<AnimeUI, AnimeAdapter.AnimeViewHolder>(diffUtil) {
     class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: AnimeUI?) {
            Glide.with(binding.ivImage.context)
                .load(item?.attributes?.posterImage?.original)
                .into(binding.ivImage)
            binding.tvName.text = item?.attributes?.titles?.enJp
        }
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<AnimeUI>() {
            override fun areItemsTheSame(oldItem: AnimeUI, newItem: AnimeUI): Boolean {
                return oldItem.attributes.titles == newItem.attributes.titles
            }

            override fun areContentsTheSame(oldItem: AnimeUI, newItem: AnimeUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}
