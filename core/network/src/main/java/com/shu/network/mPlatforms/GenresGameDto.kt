package com.shu.network.mPlatforms

import com.google.gson.annotations.SerializedName
import com.shu.models.Game
import com.shu.models.Genres
import com.shu.models.Store


data class GenresGameDto(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("games_count") var gamesCount: String? = null,
    @SerializedName("image_background") var imageBackground: String? = null,
    @SerializedName("description") var description: String? = null,

    )

fun GenresGameDto.mapFromApi(): Game {
    return with(this) {
        Game(
            id = id,
            title = name ?: "NoName",
            released = "",
            backgroundImage = imageBackground,
            added = 1,
            rating = 8.0,
            games = emptyList()
        )
    }
}