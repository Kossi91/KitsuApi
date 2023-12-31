package com.example.kitsuapi.di

import com.example.kitsuapi.presentation.ui.fragments.anime.AnimeViewModel
import com.example.kitsuapi.presentation.ui.fragments.createpost.CreatePostViewModel
import com.example.kitsuapi.presentation.ui.fragments.manga.MangaViewModel
import com.example.kitsuapi.presentation.ui.fragments.post.PostViewModel
import com.example.kitsuapi.presentation.ui.fragments.singin.SingInViewModel
import com.example.kitsuapi.presentation.ui.fragments.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
* [appModule] koin module для зависимостей app модуля
*/

val appModule = module {

    viewModel<AnimeViewModel> {
        AnimeViewModel(
            animeUseCase = get(),
            categoriesUseCase = get()
        )
    }

    viewModel<MangaViewModel> {
        MangaViewModel(
            mangaUseCase = get(),
            categoriesUseCase = get()
        )
    }

    viewModel<UserViewModel> {
        UserViewModel(
            userUseCase = get()
        )
    }

    viewModel<SingInViewModel> {
        SingInViewModel(
            singInUseCase = get()
        )
    }

    viewModel<PostViewModel> {
        PostViewModel(
             postsUseCase = get(),
            fetchUserByPostIdUseCase = get()
        )
    }

    viewModel<CreatePostViewModel> {
        CreatePostViewModel(
            fetchUserByNameUseCase = get(),
            createPostUseCase = get()
        )
    }
}