package com.picpay.desafio.android.di

import com.picpay.desafio.android.domain.usecase.GetAllUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetAllUsersUseCase(repository = get()) }
}
