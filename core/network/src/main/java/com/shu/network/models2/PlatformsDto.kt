package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.models.Platforms


data class PlatformsDto(

    @SerializedName("platform") var platform: PlatformDto? = PlatformDto()

)

fun PlatformsDto.mapFromApi(): Platforms {
    return with(this) {
        Platforms(
            platform = platform?.mapFromApi()
        )
    }
}