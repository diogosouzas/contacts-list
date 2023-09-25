package com.picpay.desafio.android.presentation.userList.adapter

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.AdapterListItemUserBinding.inflate
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.util.UserListItemViewHolder
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class UsersListAdapter : ListAdapter<User, UserListItemViewHolder>(ItemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListItemViewHolder {
        val binding = inflate(LayoutInflater.from(parent.context), parent, false)
        return UserListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.binding) {
            name.text = item.name
            username.text = item.userName
            progressBar.visibility = VISIBLE
            Picasso.get()
                .load(item.userImage)
                .error(R.drawable.ic_round_account_circle)
                .into(picture, object : Callback {
                    override fun onSuccess() {
                        progressBar.visibility = GONE
                    }

                    override fun onError(e: Exception?) {
                        progressBar.visibility = GONE
                    }
                })
        }
    }

    object ItemDiffCallback : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}
