package com.shu.network.params

data class GamesApiParams(
  val dates: String? = null,
  val ordering: String? = null
) {

  fun toMap(): Map<String, String> = mutableMapOf<String, String>().apply {
    dates?.let { put(KEY_DATES, it) }
    ordering?.let { put(KEY_ORDERING, it) }
  }

  companion object {
    const val KEY_DATES = "dates"
    const val KEY_ORDERING = "ordering"
  }
}