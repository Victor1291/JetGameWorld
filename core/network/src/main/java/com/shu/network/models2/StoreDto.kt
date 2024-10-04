package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.models.Store


data class StoreDto(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null

)

fun StoreDto.mapFromApi(): Store {
    return with(this) {
        Store(
            id = id,
            name = name,
            slug = slug,
        )
    }
}