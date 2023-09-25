package com.picpay.desafio.android.di

import com.picpay.desafio.android.common.coroutines.DispatcherProviderImpl
import com.picpay.desafio.android.presentation.userList.viewmodel.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        UserListViewModel(
            getAllUsersUseCase = get(),
            dispatcher = DispatcherProviderImpl()
        )
    }
}
