package com.example.luxora.model

data class Game(
    val id: Int,
    val name: String,
    val genre: String,
    val rating: Double,
    val play : Long,
    val photo: Int
)