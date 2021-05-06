package com.example.testmarvel.data.common

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class NetworkInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var requestOriginal = chain.request()

        val url = requestOriginal.url.newBuilder()
            .addQueryParameter("apikey", "875845bd62b336d8a07e26ac5667a4f8")
            .addQueryParameter("hash", "b6294d69dc4bccc920feb814037b904e")
            .addQueryParameter("ts", "1")
            .build()

        var newRequest = requestOriginal.newBuilder()
                .url(url)
                .build()

        return chain.proceed(newRequest);
    }
}