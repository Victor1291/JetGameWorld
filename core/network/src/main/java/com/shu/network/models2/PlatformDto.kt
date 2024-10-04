package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.models.Platform


data class PlatformDto(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null

)

fun PlatformDto.mapFromApi(): Platform {
    return with(this) {
        Platform(
            id = id,
            name = name,
            slug = slug,
        )
    }
}