package com.picpay.desafio.android.presentation.userList.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.common.coroutines.IDispatcherProvider
import com.picpay.desafio.android.domain.usecase.GetAllUsersUseCase
import com.picpay.desafio.android.presentation.userList.uiAction.UsersListAction
import com.picpay.desafio.android.presentation.userList.uiState.UsersListState
import com.picpay.desafio.android.presentation.userList.uiState.UsersListState.Loading
import com.picpay.desafio.android.presentation.userList.uiState.UsersListState.ShowAllUsersState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class UserListViewModel(
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val dispatcher: IDispatcherProvider
) : ViewModel() {

    private val _statesObserver = MutableLiveData<UsersListState>()
    val statesObserver: LiveData<UsersListState> = _statesObserver

    fun executeAction(action: UsersListAction) {
        when (action) {
            is UsersListAction.GetAllUsersAction -> getAllUsers()
        }
    }

    private fun getAllUsers() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }

        _statesObserver.value = Loading(true)
        viewModelScope.launch(dispatcher.main() + coroutineExceptionHandler) {
            _statesObserver.value = ShowAllUsersState(getAllUsersUseCase.executeAction(Unit))
            _statesObserver.value = Loading(false)
        }
    }
}
