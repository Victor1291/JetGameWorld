package com.shu.network.model.base

import com.shu.network.model.GameDto
import com.google.gson.annotations.SerializedName

data class PagedResponse(
  @SerializedName("count") val count: Int,
  @SerializedName("next") val next: String,
  @SerializedName("previous") val previous: String,
  @SerializedName("results") val results: List<GameDto>
)