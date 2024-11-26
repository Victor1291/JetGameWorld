package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.models.Genres
import com.shu.models.Store


data class GenresDto(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("games_count") var gamesCount: String? = null,
    @SerializedName("image_background") var imageBackground: String? = null,
    @SerializedName("description") var description: String? = null,

)

fun GenresDto.mapFromApi(): Genres {
    return with(this) {
        Genres(
            id = id,
            name = name,
            slug = slug,
            gamesCount = gamesCount,
            imageBackground = imageBackground,
            description = description
        )
    }
}