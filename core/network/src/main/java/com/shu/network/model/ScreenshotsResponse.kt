package com.shu.network.model

import com.google.gson.annotations.SerializedName

data class ScreenshotsResponse(
    @SerializedName("results") val results: List<ImageDto>
)