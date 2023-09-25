package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.datasource.remote.UserApi
import com.picpay.desafio.android.data.repository.UserRepositoryImpl
import com.picpay.desafio.android.domain.repository.IUserRepository
import com.picpay.desafio.android.network.ApiBuilder.provideUserApi
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single { provideUserApi(UserApi::class.java) }

    factory { UserRepositoryImpl(userApi = get()) } bind IUserRepository::class
}
