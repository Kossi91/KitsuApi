package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.user.UserResponceDto
import com.example.data.network.remote.dtos.user.UserResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * [UserApiService] Api Service для работы с пользователями
 */
interface UserApiService {

    /**
     * [fetchUser] Метод getUsers используется для получения списка пользователей.
     * Принимает следующие параметры:
     * @param limit - количество элементов на странице
     * @param offset - смещение элементов
     */
    @GET("edge/users")
    suspend fun fetchUser(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): UserResponceDto

    /**
     * Метод [fetchUsersByName] используется для получения списка пользователей,
     * удовлетворяющих заданным критериям. Принимает имя пользователя в качестве
     * параметра и возвращает объект типа UsersResponseDto.
     */
    @GET("edge/users")
    suspend fun fetchUsersByName(
        @Query("filter[name]") name: String?
    ): UserResponceDto

    /**
     * Метод [fetchUserByPostId] используется для получения информации о пользователе,
     * создавшем пост с заданным идентификатором. Принимает идентификатор поста в качестве
     * параметра и возвращает объект типа UserResponseDto.
     */
    @GET("edge/posts/{id}/user")
    suspend fun fetchUserByPostId(
        @Path("id") id: String
    ): UserResponseDto
}