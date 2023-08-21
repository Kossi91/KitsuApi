package com.example.kitsuapi.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsuapi.databinding.ItemAnimeBinding
import com.example.kitsuapi.presentation.models.anime.AnimeUI
/**
 * [AnimeAdapter] Класс [AnimeAdapter] является адаптером для RecyclerView, который используется
 * для отображения списка аниме. Он реализует интерфейс PagingDataAdapter для поддержки
 * функциональности постраничной загрузки данных
 */

class AnimeAdapter: PagingDataAdapter<AnimeUI, AnimeAdapter.AnimeViewHolder>(diffUtil) {
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

    /**
     * [diffUtil] - это объект, реализующий интерфейс DiffUtil.ItemCallback, который используется
     * для определения того, что является новым элементом в списке. Он сравнивает элементы по id и
     * содержанию, чтобы определить, нужно ли обновлять элемент в списке при изменении данных.
     */
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
