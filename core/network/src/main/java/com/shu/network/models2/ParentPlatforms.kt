package com.shu.network.models2

import com.google.gson.annotations.SerializedName


data class ParentPlatforms (

  @SerializedName("platform" ) var platform : Platform? = Platform()

)