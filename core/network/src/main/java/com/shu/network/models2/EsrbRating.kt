package com.shu.network.models2

import com.google.gson.annotations.SerializedName


data class EsrbRating (

  @SerializedName("id"      ) var id     : Int?    = null,
  @SerializedName("name"    ) var name   : String? = null,
  @SerializedName("slug"    ) var slug   : String? = null,
  @SerializedName("name_en" ) var nameEn : String? = null,
  @SerializedName("name_ru" ) var nameRu : String? = null

)