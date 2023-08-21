package com.example.kitsuapi.presentation.ui.fragments.post

import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.map
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentPostBinding
import com.example.kitsuapi.presentation.base.BaseFragment
import com.example.kitsuapi.presentation.extensions.showText
import com.example.kitsuapi.presentation.models.post.toUI
import com.example.kitsuapi.presentation.ui.adapters.PostsAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
/**
 * [PostFragment] PostsFragment наследуется от [BaseFragment], который содержит общую
 * логику для фрагментов в приложении.В данном фрагменте реализуется отображение списка постов.
 * @author Aziz
 * @since 1.0v
 */
class PostFragment : BaseFragment<FragmentPostBinding>(R.layout.fragment_post) {

    override val binding by viewBinding(FragmentPostBinding::bind)
    private val viewModel by viewModel<PostViewModel>()
    private val postsAdapter: PostsAdapter by lazy {
        PostsAdapter(this::onItemClick)
    }
    /**
     * [initialize] используется для инициализации элементов пользовательского интерфейса.
     */
    override fun initialize() {
        binding.rvPosts.adapter = postsAdapter
        postsAdapter.addLoadStateListener {
            binding.progressBar.isVisible = it.source.refresh is LoadState.Loading
        }
    }

    /**
     * [setupObserves] метод для наблюдания за данными,
     * получаемыми из ViewModel.
     */
    override fun setupObserves() {
        subscribeToPosts()
    }

    /**
     * [subscribeToPosts] Так как с бэка не приходит пользователь
     * опубликовавший пост, при маппинге через id поста происходит запрос на пользователя
     * и данные записываются в специальную пустую модельку и передаются в адаптер
     */
    private fun subscribeToPosts() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.postsFlow.collectLatest {
                postsAdapter.submitData(it.map { dataItem ->
                    val user = viewModel.fetchUser(dataItem.id)
                    dataItem.relationships.user = user
                    dataItem.toUI()
                })
            }
        }
    }
    /**
     * [onItemClick] В данном методе реализуется отображение тоста с идентификатором элемента списка.
     */
    private fun onItemClick(id: String) {
        showText(id)
    }
}