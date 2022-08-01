package com.eru.rickandmorty

import java.io.Serializable

data class Character(
    val status: String,
    val name: String,
    val image: Int
):Serializable
