package com.shu.network.model

import com.google.gson.annotations.SerializedName

data class ImageDto(
  @SerializedName("image") val image: String,
)