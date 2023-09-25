package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.common.toModel
import com.picpay.desafio.android.data.datasource.remote.UserApi
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.repository.IUserRepository

class UserRepositoryImpl(private val userApi: UserApi) : IUserRepository {

    override suspend fun getAllUsers(): List<User> {
        return userApi.getAllUsers().toModel()
    }
}
