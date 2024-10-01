package com.shu.models

data class Game(
    val id: Int?,
    val title: String,
    val released: String,
    val backgroundImage: String?,
    val added: Int?,
    val rating: Double?,
    val games: List<GameShort>,
)