package com.picpay.desafio.android.common

interface MapToModel<Model> {
    fun toModel(): Model
}

fun <Model> Iterable<MapToModel<Model>>.toModel() = this.map { it.toModel() }
