package com.example.data.network.remote.apiservices

import com.example.data.network.remote.dtos.auth.AuthModelDto
import com.example.data.network.remote.dtos.auth.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * [SignInApiService] Api Service для работы с авторизацией пользователя
 */
interface SignInApiService {

    /**
     * [postAuthDataUser] Функция выполняет запрос на сервер API, чтобы аутентифицировать пользователя
     * и вернуть токен доступа для дальнейшей работы с API. Если запрос прошел успешно,
     * функция возвращает объект [LoginResponseDto].
     * [authModel] - тело запроса в виде объекта [AuthModelDto].
     */
    @POST("oauth/token")
    suspend fun postAuthDataUser(
        @Body authModel: AuthModelDto
    ): LoginResponseDto
}
