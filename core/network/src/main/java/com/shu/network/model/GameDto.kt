package com.shu.network.model

import com.google.gson.annotations.SerializedName
import com.shu.models.Game

data class GameDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("background_image") val image: String,
    @SerializedName("released") val released: String,
    @SerializedName("added") val added: Int?,
    @SerializedName("rating") val rating: Double,
)


fun GameDto.mapFromApi(): Game {
    return with(this) {
        Game(
            id = id,
            title = name,
            released = released,
            backgroundImage = image,
            added = added,
            rating = rating,
            games = emptyList()
        )
    }
}