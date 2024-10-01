package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.network.models2.Store


data class Stores (

  @SerializedName("store" ) var store : Store? = Store()

)