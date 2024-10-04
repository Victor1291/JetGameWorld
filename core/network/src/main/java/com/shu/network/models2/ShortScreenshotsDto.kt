package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.models.ShortScreenshots
import com.shu.models.Store


data class ShortScreenshotsDto(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("image") var image: String? = null

)

fun ShortScreenshotsDto.mapFromApi(): ShortScreenshots {
    return with(this) {
        ShortScreenshots(
            id = id,
            image = image,
        )
    }
}