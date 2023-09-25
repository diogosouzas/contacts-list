package com.picpay.desafio.android.network

import com.picpay.desafio.android.BuildConfig.PICPAY_API
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiBuilder {
    private val baseClient = OkHttpClient()

    fun <S> provideUserApi(
        serviceClass: Class<S>,
        baseUrl: String = PICPAY_API,
        readTimeout: Long = 30,
    ): S {
        val builder = baseClient.newBuilder()
            .readTimeout(readTimeout, TimeUnit.SECONDS)

        val client = builder
            .connectionSpecs(listOf(ConnectionSpec.COMPATIBLE_TLS))
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(serviceClass)
    }
}
