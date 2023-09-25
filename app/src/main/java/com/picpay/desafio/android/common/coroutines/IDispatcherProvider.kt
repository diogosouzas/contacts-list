package com.picpay.desafio.android.common.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface IDispatcherProvider {

    fun main(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
}
