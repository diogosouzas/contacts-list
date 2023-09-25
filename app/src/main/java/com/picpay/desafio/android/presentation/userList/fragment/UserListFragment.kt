package com.picpay.desafio.android.presentation.userList.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.databinding.FragmentUsersListBinding
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.presentation.userList.adapter.UsersListAdapter
import com.picpay.desafio.android.presentation.userList.uiAction.UsersListAction.GetAllUsersAction
import com.picpay.desafio.android.presentation.userList.uiState.UsersListState.Loading
import com.picpay.desafio.android.presentation.userList.uiState.UsersListState.ShowAllUsersState
import com.picpay.desafio.android.presentation.userList.viewmodel.UserListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : Fragment() {

    private val binding: FragmentUsersListBinding by lazy {
        FragmentUsersListBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<UserListViewModel>()
    private val usersAdapter: UsersListAdapter = UsersListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        getAllUser()
        setupObservables()
    }

    private fun setupView() = with(binding.recyclerView) {
        adapter = usersAdapter
        layoutManager = LinearLayoutManager(context)
    }

    private fun getAllUser() {
        viewModel.executeAction(GetAllUsersAction)
    }

    private fun setupObservables() {
        viewModel.statesObserver.observe(viewLifecycleOwner) { state ->
            when (state) {
                is Loading -> setupLoading(state.isLoading)
                is ShowAllUsersState -> populateUsersList(state.userList)
            }
        }
    }

    private fun setupLoading(isLoading: Boolean) {
        binding.userListProgressBar.isVisible = isLoading
    }

    private fun populateUsersList(usersList: List<User>) {
        usersAdapter.apply {
            submitList(usersList)
            notifyItemRangeChanged(START_POSITION, usersList.size)
        }
    }

    private companion object {
        const val START_POSITION = 0
    }
}
