package com.picpay.desafio.android.data.model.response

import com.google.gson.annotations.SerializedName
import com.picpay.desafio.android.common.MapToModel
import com.picpay.desafio.android.domain.model.User

data class UserResponse(
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String
) : MapToModel<User> {

    override fun toModel() = User(
        userImage = img,
        name = name,
        userId = id,
        userName = username
    )
}
