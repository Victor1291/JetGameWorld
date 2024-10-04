package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.models.Stores


data class StoresDto(

    @SerializedName("store") var store: StoreDto? = StoreDto()

)

fun StoresDto.mapFromApi(): Stores {
    return with(this) {
        Stores(
            store = store?.mapFromApi()
        )
    }
}