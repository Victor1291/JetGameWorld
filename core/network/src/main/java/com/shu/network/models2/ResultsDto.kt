package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.models.Game


data class ResultsDto (

    @SerializedName("slug"               ) var slug             : String?                     = null,
    @SerializedName("name"               ) var name             : String?                     = null,
    @SerializedName("playtime"           ) var playtime         : Int?                        = null,
    @SerializedName("platforms"          ) var platforms        : ArrayList<Platforms>        = arrayListOf(),
    @SerializedName("stores"             ) var stores           : ArrayList<Stores>           = arrayListOf(),
    @SerializedName("released"           ) var released         : String?                     = null,
    @SerializedName("tba"                ) var tba              : Boolean?                    = null,
    @SerializedName("background_image"   ) var backgroundImage  : String?                     = null,
    @SerializedName("rating"             ) var rating           : Double?                     = null,
    @SerializedName("rating_top"         ) var ratingTop        : Int?                        = null,
    @SerializedName("ratings"            ) var ratings          : ArrayList<Ratings>          = arrayListOf(),
    @SerializedName("ratings_count"      ) var ratingsCount     : Int?                        = null,
    @SerializedName("reviews_text_count" ) var reviewsTextCount : Int?                        = null,
    @SerializedName("added"              ) var added            : Int?                        = null,
    @SerializedName("added_by_status"    ) var addedByStatus    : AddedByStatus?              = AddedByStatus(),
    @SerializedName("metacritic"         ) var metacritic       : Int?                        = null,
    @SerializedName("suggestions_count"  ) var suggestionsCount : Int?                        = null,
    @SerializedName("updated"            ) var updated          : String?                     = null,
    @SerializedName("id"                 ) var id               : Int?                        = null,
    @SerializedName("score"              ) var score            : String?                     = null,
    @SerializedName("clip"               ) var clip             : String?                     = null,
    @SerializedName("tags"               ) var tags             : ArrayList<Tags>             = arrayListOf(),
    @SerializedName("esrb_rating"        ) var esrbRating       : EsrbRating?                 = EsrbRating(),
    @SerializedName("user_game"          ) var userGame         : String?                     = null,
    @SerializedName("reviews_count"      ) var reviewsCount     : Int?                        = null,
    @SerializedName("saturated_color"    ) var saturatedColor   : String?                     = null,
    @SerializedName("dominant_color"     ) var dominantColor    : String?                     = null,
    @SerializedName("short_screenshots"  ) var shortScreenshots : ArrayList<ShortScreenshots> = arrayListOf(),
    @SerializedName("parent_platforms"   ) var parentPlatforms  : ArrayList<ParentPlatforms>  = arrayListOf(),
    @SerializedName("genres"             ) var genres           : ArrayList<Genres>           = arrayListOf()

)

fun ResultsDto.mapFromApi(): Game {
    return with(this) {
        Game(
            id = id,
            title = name ?: "",
            released = released ?: "",
            backgroundImage = backgroundImage,
            added = added,
            rating = rating,
            games = emptyList()
        )
    }
}