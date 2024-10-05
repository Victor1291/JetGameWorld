package com.shu.network.mPlatforms

import com.google.gson.annotations.SerializedName

data class ResponseGenres(
    @SerializedName("count") var count: Int? = null,
    @SerializedName("next") var next: String? = null,
    @SerializedName("previous") var previous: String? = null,
    @SerializedName("results") var results: List<GenresGameDto> = listOf()

)
