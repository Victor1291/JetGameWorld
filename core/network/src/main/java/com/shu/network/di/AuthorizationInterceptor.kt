package com.shu.network.di

import com.shu.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

open class AuthorizationInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return proceedRequestWithAuthorization(chain)
    }

    private fun proceedRequestWithAuthorization(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("key", BuildConfig.API_KEY).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}