package com.shu.models

data class Game(
    val id: Int?,
    val title: String,
    val released: String,
    val backgroundImage: String?,
    val added: Int?,
    val rating: Double?,
    val games: List<GameShort>,
    var platforms        : String?                     = null,
   // var stores           : List<Stores>           = listOf(),
    var clip             : String?                     = null,
   // var tags             : List<Tags>             = listOf(),
    var userGame         : String?                     = null,
    var reviewsCount     : Int?                        = null,
    var saturatedColor   : String?                     = null,
    var dominantColor    : String?                     = null,
    var shortScreenshots : List<ShortScreenshots> = listOf(),
   // var parentPlatforms  : List<ParentPlatforms>  = listOf(),
    var genres           : String?                     = null,
)