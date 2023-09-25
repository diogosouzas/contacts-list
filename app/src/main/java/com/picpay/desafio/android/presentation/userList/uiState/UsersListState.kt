package com.picpay.desafio.android.presentation.userList.uiState

import com.picpay.desafio.android.domain.model.User

sealed class UsersListState {
    data class ShowAllUsersState(val userList: List<User>) : UsersListState()
    data class Loading(val isLoading: Boolean) : UsersListState()
}
