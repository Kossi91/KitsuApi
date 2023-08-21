package com.example.kitsuapi.presentation.ui.fragments.createpost

import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentCreatePostBinding
import com.example.kitsuapi.presentation.base.BaseFragment
import com.example.kitsuapi.presentation.extensions.showText
import com.example.kitsuapi.presentation.models.user.UserUI
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * [CreatePostFragment] наследуется от [BaseFragment] и содержит реализацию функционала
 * создания поста. Он также содержит приватную переменную user, которая используется для
 * получения информации о пользователе, создающем пост.
 * @author Aziz
 * @since 1.0v
 */
class CreatePostFragment : BaseFragment<FragmentCreatePostBinding>(R.layout.fragment_create_post) {

    override val binding by viewBinding(FragmentCreatePostBinding::bind)
    private val viewModel by viewModel<CreatePostViewModel>()
    private var user: UserUI? = null

    /**
     * Метод [setupListeners] используется для настройки обработчиков событий пользовательского ввода.
     */
    override fun setupListener() {
        binding.tvPost.setOnClickListener {
            createPost()
        }
        binding.tvCancel.setOnClickListener {
            findNavController().navigateUp()
        }
    }
    /**
     * [setupObserves] Тут опять из за бэка приходится писать фигню (⊙_⊙),
     * идет запрос на текущего пользователя по никнейму,
     * [subscribeToUser] в ответе получаем список пользователей с похожими никнеймами
     */
    override fun setupObserves() {
        viewModel.getUser("Kossi")
        subscribeToCreatePostState()
        subscribeToUser()
    }
    /**
     * Метод [subscribeToUser] используется для подписки на изменения состояний при получении
     * информации о пользователе. Если получение происходит успешно, то происходит заполнение
     * полей фрагмента информацией о пользователе. Если получение происходит неудачно,
     * то выводится сообщение об ошибке.
     */
    private fun subscribeToUser() {
        viewModel.userFlow.spectateUiState(
            loading = { binding.progressBar.visibility = View.VISIBLE },
            success = { data ->
                binding.progressBar.visibility = View.GONE
                user = data.first { user ->
                    user.attributes.name == "Kossi"
                }
                user?.attributes?.name?.let { binding.tvUserName.text = it }
                if (user?.attributes?.avatar?.original != null) {
                    Glide.with(binding.ivUserImage.context)
                        .load(user?.attributes?.avatar?.original)
                        .into(binding.ivUserImage)
                } else {
                    binding.ivUserImage.setImageResource(R.drawable.ava)
                }
            },
            error = { showText(it) }
        )
    }

    /**
     * Метод [subscribeToCreatePostState] используется для подписки на изменения состояний при
     * создании поста. Если создание поста происходит успешно, то происходит перенаправление на
     * предыдущий экран. Если создание поста происходит неудачно, то выводится сообщение об ошибке.
     */
    private fun subscribeToCreatePostState() {
        viewModel.fetchCreatePostState.spectateUiState(
            loading = {
                binding.progressBar.visibility = View.VISIBLE
            },
            success = {
                binding.progressBar.visibility = View.GONE
                showText("Success")
                findNavController().navigateUp()
            },
            error = {
                binding.progressBar.visibility = View.GONE
                showText(it)
                Log.e("Aziz" , it.toString())
            }
        )
    }

    /**
    [createPost] Функция для создания нового поста.
    Если ID пользователя равен null то выводится сообщение об ошибке.
    Если поле ввода контента пустое или равно null, выводится сообщение об ошибке.
    Иначе вызывается метод createPost у экземпляра ViewModel с передачей параметров:
    userId - ID пользователя,
    content - контент поста,
    nsfw - флаг, указывающий на то, является ли пост NSFW,
    spoiler - флаг, указывающий на то, содержит ли пост спойлеры.
     */
    private fun createPost() {
        if (user?.id == null) {
            showText(getString(R.string.unknown_error))
        } else if (binding.etContent.text.isNullOrBlank()) {
            binding.etContent.error = getString(R.string.input_text)
        } else {
            viewModel.createPost(
                userId = user!!.id,
                content = binding.etContent.text.toString(),
                nsfw = binding.cbNsfw.isChecked,
                spoiler = binding.cbSpoiler.isChecked
            )
        }
    }
}