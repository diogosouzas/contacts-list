package com.picpay.desafio.android.common

interface UseCase<Params, Return> {
    suspend fun executeAction(params: Params): Return
}
