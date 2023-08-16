package com.example.data.network.repostories

import com.example.data.local.prefs.TokenPreferenceHelper
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import java.net.ProtocolException
import javax.inject.Inject

class TokenInterceptor(
    private val tokenManager: TokenPreferenceHelper
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.newBuilder()
        if (request.header("Authorization") == null) {
            tokenManager.accessToken?.let { token ->
                builder.addHeader(
                    "Authorization:",
                    "Bearer $token"
                )
            }
        }
        return try {
            chain.proceed(builder.build())
        } catch (e: ProtocolException) {
            val emptyBody = "".toResponseBody("text/plain".toMediaTypeOrNull())
            ResponseBody

            return chain.proceed(builder.build())
                .newBuilder()
                .code(200)
                .body(emptyBody)
                .build()
        }
    }
}
