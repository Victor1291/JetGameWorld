package com.shu.network.models2

import com.google.gson.annotations.SerializedName


data class Tags (

  @SerializedName("id"               ) var id              : Int?    = null,
  @SerializedName("name"             ) var name            : String? = null,
  @SerializedName("slug"             ) var slug            : String? = null,
  @SerializedName("language"         ) var language        : String? = null,
  @SerializedName("games_count"      ) var gamesCount      : Int?    = null,
  @SerializedName("image_background" ) var imageBackground : String? = null

)