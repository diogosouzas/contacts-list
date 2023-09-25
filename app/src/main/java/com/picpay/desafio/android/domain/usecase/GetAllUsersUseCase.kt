package com.picpay.desafio.android.domain.usecase

import com.picpay.desafio.android.common.UseCase
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.repository.IUserRepository

class GetAllUsersUseCase(private val repository: IUserRepository) : UseCase<Unit, List<User>> {

    override suspend fun executeAction(params: Unit): List<User> {
        return repository.getAllUsers()
    }
}
