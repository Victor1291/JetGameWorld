package com.shu.network.model_detail


import com.google.gson.annotations.SerializedName
import com.shu.network.models2.AddedByStatusDto
import com.shu.network.models2.EsrbRatingDto
import com.shu.network.models2.PlatformsDto
import com.shu.network.models2.RatingsDto

data class ResultDetailDto (

    @SerializedName("id"                          ) var id                        : Int?                           = null,
    @SerializedName("slug"                        ) var slug                      : String?                        = null,
    @SerializedName("name"                        ) var name                      : String?                        = null,
    @SerializedName("name_original"               ) var nameOriginal              : String?                        = null,
    @SerializedName("description"                 ) var description               : String?                        = null,
    @SerializedName("metacritic"                  ) var metacritic                : Int?                           = null,
    @SerializedName("metacritic_platforms"        ) var metacriticPlatforms       : ArrayList<MetacriticPlatformsDto> = arrayListOf(),
    @SerializedName("released"                    ) var released                  : String?                        = null,
    @SerializedName("tba"                         ) var tba                       : Boolean?                       = null,
    @SerializedName("updated"                     ) var updated                   : String?                        = null,
    @SerializedName("background_image"            ) var backgroundImage           : String?                        = null,
    @SerializedName("background_image_additional" ) var backgroundImageAdditional : String?                        = null,
    @SerializedName("website"                     ) var website                   : String?                        = null,
    @SerializedName("rating"                      ) var rating                    : Int?                           = null,
    @SerializedName("rating_top"                  ) var ratingTop                 : Int?                           = null,
    @SerializedName("ratings"                     ) var ratings                   : RatingsDto?                       = RatingsDto(),
  //  @SerializedName("reactions"                   ) var reactions                 : Reactions?                     = Reactions(),
    @SerializedName("added"                       ) var added                     : Int?                           = null,
    @SerializedName("added_by_status"             ) var addedByStatus             : AddedByStatusDto?                 = AddedByStatusDto(),
    @SerializedName("playtime"                    ) var playtime                  : Int?                           = null,
    @SerializedName("screenshots_count"           ) var screenshotsCount          : Int?                           = null,
    @SerializedName("movies_count"                ) var moviesCount               : Int?                           = null,
    @SerializedName("creators_count"              ) var creatorsCount             : Int?                           = null,
    @SerializedName("achievements_count"          ) var achievementsCount         : Int?                           = null,
    @SerializedName("parent_achievements_count"   ) var parentAchievementsCount   : String?                        = null,
    @SerializedName("reddit_url"                  ) var redditUrl                 : String?                        = null,
    @SerializedName("reddit_name"                 ) var redditName                : String?                        = null,
    @SerializedName("reddit_description"          ) var redditDescription         : String?                        = null,
    @SerializedName("reddit_logo"                 ) var redditLogo                : String?                        = null,
    @SerializedName("reddit_count"                ) var redditCount               : Int?                           = null,
    @SerializedName("twitch_count"                ) var twitchCount               : String?                        = null,
    @SerializedName("youtube_count"               ) var youtubeCount              : String?                        = null,
    @SerializedName("reviews_text_count"          ) var reviewsTextCount          : String?                        = null,
    @SerializedName("ratings_count"               ) var ratingsCount              : Int?                           = null,
    @SerializedName("suggestions_count"           ) var suggestionsCount          : Int?                           = null,
    @SerializedName("alternative_names"           ) var alternativeNames          : ArrayList<String>              = arrayListOf(),
    @SerializedName("metacritic_url"              ) var metacriticUrl             : String?                        = null,
    @SerializedName("parents_count"               ) var parentsCount              : Int?                           = null,
    @SerializedName("additions_count"             ) var additionsCount            : Int?                           = null,
    @SerializedName("game_series_count"           ) var gameSeriesCount           : Int?                           = null,
    @SerializedName("esrb_rating"                 ) var esrbRating                : EsrbRatingDto?                    = EsrbRatingDto(),
    @SerializedName("platforms"                   ) var platforms                 : ArrayList<PlatformsDto>           = arrayListOf()

)