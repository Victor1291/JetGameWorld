package com.shu.network.mPlatforms

import com.google.gson.annotations.SerializedName
import com.shu.models.GameShort

data class GamesDto(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("added") var added: Int? = null

)

fun GamesDto.mapFromApi(): GameShort {
    return with(this) {
        GameShort(
            id = id,
            slug = slug,
            title = name,
            added = added,
        )
    }
}