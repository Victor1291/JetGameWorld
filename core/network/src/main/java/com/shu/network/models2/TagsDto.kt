package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.models.Store
import com.shu.models.Tags


data class TagsDto(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("language") var language: String? = null,
    @SerializedName("games_count") var gamesCount: Int? = null,
    @SerializedName("image_background") var imageBackground: String? = null

)

fun TagsDto.mapFromApi(): Tags {
    return with(this) {
        Tags(
            id = id,
            name = name,
            slug = slug,
            language = language,
            gamesCount = gamesCount,
            imageBackground = imageBackground,
        )
    }
}