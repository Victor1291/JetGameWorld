package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.network.model.Response


data class PagedResponseDto(

    @SerializedName("count") var count: Int? = null,
    @SerializedName("next") var next: String? = null,
    @SerializedName("previous") var previous: String? = null,
    @SerializedName("results") var results: ArrayList<ResultsDto> = arrayListOf(),
    @SerializedName("user_platforms") var userPlatforms: Boolean? = null

)

fun PagedResponseDto.mapFromApi(): Response {
    return with(this) {
        Response(
            count, next, previous, results.map { it.mapFromApiToBd() }
        )
    }
}