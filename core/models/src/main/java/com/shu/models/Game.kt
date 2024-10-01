package com.shu.models

data class Game(
    val id: Long,
    //val slug: String,
    val name: String,
    val released: String,
   // val tba: Boolean,
    val backgroundImage: String,
    val added: Long,
    val rating: Float,
   // val ratingTop: Int,
   // val ratingsCount: Int,
  //  val reviewsTextCount: String,

)