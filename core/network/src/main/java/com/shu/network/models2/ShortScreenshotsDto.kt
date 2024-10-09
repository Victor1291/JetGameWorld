package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.database.models.ShortScreenshotsDbo
import com.shu.models.ShortScreenshots


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
fun ShortScreenshotsDto.mapFromApiToBd(): ShortScreenshotsDbo {
    return with(this) {
        ShortScreenshotsDbo(
            id = id,
            image = image,
        )
    }
}
