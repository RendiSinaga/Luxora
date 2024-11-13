package com.example.luxora.model

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val category: String,
    val rating: Double,
    val photo : Int
)