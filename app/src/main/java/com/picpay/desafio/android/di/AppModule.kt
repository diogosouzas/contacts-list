package com.picpay.desafio.android.di

import org.koin.core.module.Module

object AppModule {

    fun getModules(): List<Module> = listOf(
        dataModule,
        useCaseModule,
        uiModule,
        commonModule
    )
}
