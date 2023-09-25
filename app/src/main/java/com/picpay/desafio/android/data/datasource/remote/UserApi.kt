package com.picpay.desafio.android.data.datasource.remote

import com.picpay.desafio.android.data.model.response.UserResponse
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    fun getAllUsers(): List<UserResponse>
}
