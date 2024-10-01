package com.shu.network.mPlatforms

import com.google.gson.annotations.SerializedName
import com.shu.models.Game

data class RPlatforms(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("games_count") var gamesCount: Int? = null,
    @SerializedName("image_background") var imageBackground: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("year_start") var yearStart: String? = null,
    @SerializedName("year_end") var yearEnd: String? = null,
    @SerializedName("games") var games: ArrayList<GamesDto> = arrayListOf()
)


fun RPlatforms.mapFromApi(): Game {
    return with(this) {
        Game(
            id = id,
            title = name ?: "NoName",
            released = yearStart ?: "",
            backgroundImage = imageBackground,
            added = 1,
            rating = 8.0,
            games = games.map { it.mapFromApi() }
        )
    }
}