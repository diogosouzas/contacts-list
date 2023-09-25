package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.domain.model.User

interface IUserRepository {
    suspend fun getAllUsers(): List<User>
}
