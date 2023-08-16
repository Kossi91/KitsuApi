package com.example.domain.repostories

import androidx.paging.PagingData
import com.example.domain.either.Either
import com.example.domain.models.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun fetchUser() : Flow<PagingData<User>>

    fun fetchUsersByName(name: String?): Flow<Either<String, List<User>>>

    suspend fun fetchUserByPostId(id: String): User
}