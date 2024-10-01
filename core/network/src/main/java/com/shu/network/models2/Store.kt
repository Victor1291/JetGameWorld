package com.shu.network.models2

import com.google.gson.annotations.SerializedName


data class Store (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("slug" ) var slug : String? = null

)