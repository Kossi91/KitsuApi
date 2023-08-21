package com.example.kitsuapi.presentation.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.PagerBoardBinding
import com.example.kitsuapi.presentation.models.onboard.OnBoardUI

/**
 * Адаптер [OnBoardAdapter] используется для управления отображением данных в ViewPager
 * внутри BoardFragment, отображая пользователю информацию на страницах OnBoarding.
 */

class OnBoardAdapter( private val context: Context) : Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    /**
     * Адаптер содержит список [list] OnBoardUI, каждый элемент которого содержит заголовок,
     * описание и изображение. Каждый элемент списка отображается на своей странице ViewPager.
     * Когда пользователь листает страницы ViewPager, внутренний слушатель OnPageChangeCallback
     * изменяет видимость кнопок в зависимости от текущей страницы. Кнопка "Next" скрывается
     * на последней странице, а кнопка "Start" становится видимой только на последней странице.
     */
    private val list = listOf(
        OnBoardUI(
            context.getString(R.string.on_board_1),
            context.getString(R.string.on_board_1_title),
            R.drawable.board_1
        ),
        OnBoardUI(
            context.getString(R.string.on_board_2),
            context.getString(R.string.on_board_2_title),
            R.drawable.board_2
        ),
        OnBoardUI(
            context.getString(R.string.on_board_3),
            context.getString(R.string.on_board_3_title),
            R.drawable.board_3
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OnBoardViewHolder(
        PagerBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class OnBoardViewHolder(private val binding: PagerBoardBinding) :
        ViewHolder(binding.root) {

        fun onBind(model: OnBoardUI) = with(binding) {
            ivBoard.setImageResource(model.image)
            tvTitle.text = model.title
            tvInfo.text = model.description
        }
    }
}