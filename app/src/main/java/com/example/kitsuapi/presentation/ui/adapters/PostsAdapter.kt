package com.example.kitsuapi.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsuapi.databinding.ItemPostsBinding
import com.example.kitsuapi.presentation.models.post.DataItemUI

class PostsAdapter(
    private val onItemCLick: (id: String) -> Unit,
) : PagingDataAdapter<DataItemUI, PostsAdapter.PostViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        ItemPostsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class PostViewHolder(private val binding: ItemPostsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: DataItemUI) = with(binding) {
            tvContent.text = data.attributes.content
            tvUsername.text = data.relationships.user.attributes.name
            data.relationships.user.attributes.avatar?.original?.let {
                Glide.with(ivUserAvatar.context)
                    .load(it)
                    .into(ivUserAvatar)
            }
            if (data?.attributes?.embed?.url != null) {
                ivContentImage.visibility = View.VISIBLE
                Glide.with(ivContentImage.context)
                    .load(data.attributes.embed.url)
                    .into(ivContentImage)
            } else {
                ivContentImage.visibility = View.GONE
            }
            if (data?.attributes?.spoiler != null) {
                if (data.attributes.spoiler) {
                    tvContent.visibility = View.GONE
                    ivContentImage.visibility = View.GONE
                    spoilerContainer.visibility = View.VISIBLE
                }
            }

            binding.spoilerContainer.setOnClickListener {
                binding.tvContent.visibility = View.VISIBLE
                binding.spoilerContainer.visibility = View.GONE
                if (data?.attributes?.embed?.url != null) {
                    binding.ivContentImage.visibility = View.VISIBLE
                }
            }
        }

        init {
            itemView.setOnClickListener {
                onItemCLick(getItem(absoluteAdapterPosition)?.id.toString())
            }
        }
    }

    companion object {
        val diffCallBack = object : DiffUtil.ItemCallback<DataItemUI>() {
            override fun areItemsTheSame(oldItem: DataItemUI, newItem: DataItemUI): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataItemUI, newItem: DataItemUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}
