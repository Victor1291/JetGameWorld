package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.network.models2.Platform


data class Platforms (

  @SerializedName("platform" ) var platform : Platform? = Platform()

)