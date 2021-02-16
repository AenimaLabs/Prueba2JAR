package com.example.prueba2jar.data

data class GamesDetail(
    val id: Int,

    val background_image: String,
    val delivery: Boolean,
    val format: String,
    val genres: String,
    val lastPrice: Int,
    val metacritic: Int,
    val name: String,
    val platforms: String,
    val playtime: Int,
    val price: Int,
    val rating: Double,
    val released: String
)