package com.example.data.network.repostories

import okhttp3.Interceptor
import okhttp3.Response

const val accessToken: String = "access_token"

class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url =
            request.url.newBuilder()
                .addQueryParameter(
                    "Authorization:",
                    "Bearer $accessToken"
                )
                .build()
        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}