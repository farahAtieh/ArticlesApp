package com.frhatieh.articlesapp.data.network

import com.frhatieh.articlesapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AppInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url
        val updatedUrl = url.newBuilder()
            .addQueryParameter("api-key", BuildConfig.API_KEY)
            .build()

        val requestBuilder = request.newBuilder()
            .url(updatedUrl)
            .build()

        return chain.proceed(requestBuilder)
    }
}