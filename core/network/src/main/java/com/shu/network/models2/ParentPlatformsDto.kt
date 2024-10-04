package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.models.ParentPlatforms
import com.shu.models.Platforms


data class ParentPlatformsDto (

  @SerializedName("platform" ) var platform : PlatformDto? = PlatformDto()

)

fun ParentPlatformsDto.mapFromApi(): ParentPlatforms {
  return with(this) {
    ParentPlatforms(
      platform = platform?.mapFromApi()
    )
  }
}