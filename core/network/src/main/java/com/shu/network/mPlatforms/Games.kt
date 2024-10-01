package com.shu.network.mPlatforms

import com.google.gson.annotations.SerializedName

data class Games(

    @SerializedName("id"    ) var id    : Int?    = null,
    @SerializedName("slug"  ) var slug  : String? = null,
    @SerializedName("name"  ) var name  : String? = null,
    @SerializedName("added" ) var added : Int?    = null

)

