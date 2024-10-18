package com.shu.network.model_detail

import com.google.gson.annotations.SerializedName

data class MetacriticPlatformsDto(

    @SerializedName("metascore" ) var metascore : Int?    = null,
    @SerializedName("url"       ) var url       : String? = null
)
