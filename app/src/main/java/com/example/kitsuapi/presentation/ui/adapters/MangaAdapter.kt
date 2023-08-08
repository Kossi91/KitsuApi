package com.example.kitsuapi.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsuapi.databinding.ItemMangaBinding
import com.example.kitsuapi.presentation.models.manga.MangaUI

class MangaAdapter : PagingDataAdapter<MangaUI, MangaAdapter.MangaViewHolder>(diffUtil) {
    inner class MangaViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: MangaUI?) {
            Glide.with(binding.ivImage.context)
                .load(item?.attributes?.posterImage?.original)
                .into(binding.ivImage)
            binding.tvName.text = item?.attributes?.titles?.enJp
        }
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(
            ItemMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MangaUI>() {
            override fun areItemsTheSame(oldItem: MangaUI, newItem: MangaUI): Boolean {
                return oldItem.attributes.titles == newItem.attributes.titles
            }

            override fun areContentsTheSame(oldItem: MangaUI, newItem: MangaUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}