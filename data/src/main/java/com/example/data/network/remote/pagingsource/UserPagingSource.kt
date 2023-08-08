package com.example.data.network.remote.pagingsource

import com.example.data.network.remote.apiservices.UserApiService
import com.example.data.network.remote.dtos.user.UserDto
import com.example.data.network.remote.dtos.user.toDomain
import com.example.data.network.remote.pagingsource.base.BaseUserPagingSource
import com.example.domain.models.user.User
import javax.inject.Inject

class UserPagingSource @Inject constructor(
    private val service: UserApiService
) : BaseUserPagingSource<UserDto, User>(
    { service.getUser(10, it)},
    {data -> data.map { it.toDomain() }}
)




