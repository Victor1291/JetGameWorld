package com.shu.network.model

import com.shu.database.models.GameDbo
import com.shu.models.Game

data class Response(
    var count: Int? = null,
    var next: String? = null,
    var previous: String? = null,
    var results: List<GameDbo> = listOf()
)
