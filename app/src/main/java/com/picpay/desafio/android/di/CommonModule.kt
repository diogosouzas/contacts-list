package com.picpay.desafio.android.di

import com.picpay.desafio.android.common.coroutines.DispatcherProviderImpl
import com.picpay.desafio.android.common.coroutines.IDispatcherProvider
import org.koin.dsl.module

val commonModule = module {
    single<IDispatcherProvider> { DispatcherProviderImpl() }
}
