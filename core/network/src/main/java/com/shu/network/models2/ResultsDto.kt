package com.shu.network.models2

import com.google.gson.annotations.SerializedName
import com.shu.database.models.GameDbo
import com.shu.models.Game


data class ResultsDto(

    @SerializedName("slug") var slug: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("playtime") var playtime: Int? = null,
    @SerializedName("platforms") var platforms: ArrayList<PlatformsDto> = arrayListOf(),
    @SerializedName("stores") var stores: ArrayList<StoresDto> = arrayListOf(),
    @SerializedName("released") var released: String? = null,
    @SerializedName("tba") var tba: Boolean? = null,
    @SerializedName("background_image") var backgroundImage: String? = null,
    @SerializedName("rating") var rating: Double? = null,
    @SerializedName("rating_top") var ratingTop: Int? = null,
    @SerializedName("ratings") var ratings: ArrayList<RatingsDto> = arrayListOf(),
    @SerializedName("ratings_count") var ratingsCount: Int? = null,
    @SerializedName("reviews_text_count") var reviewsTextCount: Int? = null,
    @SerializedName("added") var added: Int? = null,
    @SerializedName("added_by_status") var addedByStatus: AddedByStatusDto? = AddedByStatusDto(),
    @SerializedName("metacritic") var metacritic: Int? = null,
    @SerializedName("suggestions_count") var suggestionsCount: Int? = null,
    @SerializedName("updated") var updated: String? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("score") var score: String? = null,
    @SerializedName("clip") var clip: String? = null,
    @SerializedName("tags") var tags: ArrayList<TagsDto> = arrayListOf(),
    @SerializedName("esrb_rating") var esrbRating: EsrbRatingDto? = EsrbRatingDto(),
    @SerializedName("user_game") var userGame: String? = null,
    @SerializedName("reviews_count") var reviewsCount: Int? = null,
    @SerializedName("saturated_color") var saturatedColor: String? = null,
    @SerializedName("dominant_color") var dominantColor: String? = null,
    @SerializedName("short_screenshots") var shortScreenshots: ArrayList<ShortScreenshotsDto> = arrayListOf(),
    @SerializedName("parent_platforms") var parentPlatforms: ArrayList<ParentPlatformsDto> = arrayListOf(),
    @SerializedName("genres") var genres: ArrayList<GenresDto> = arrayListOf()

)

fun ResultsDto.mapFromApi(): Game {
    return with(this) {
        Game(
            id = id ?: 1,
            title = name ?: "",
            released = released ?: "",
            backgroundImage = backgroundImage,
            added = added,
            rating = rating,
            games = emptyList(),
            platforms = platforms.joinToString(",") { it.platform?.name ?: "" },
            //stores = stores.map { it.mapFromApi() },
            clip = clip,
            // tags = tags.map { it.mapFromApi() },
            userGame = userGame,
            reviewsCount = reviewsCount,
            saturatedColor = saturatedColor,
            dominantColor = dominantColor,
            shortScreenshots = shortScreenshots.map { it.mapFromApi() },
            // parentPlatforms = parentPlatforms.map { it.mapFromApi() },
            genres = genres.joinToString(",") { it.name ?: "" },
        )
    }
}

fun ResultsDto.mapFromApiToBd(): GameDbo {
    return with(this) {
        GameDbo(
            id = id ?: 0,
            title = name ?: "",
            released = released ?: "",
            backgroundImage = backgroundImage,
            added = added,
            rating = rating,
            platforms = platforms.joinToString(",") { it.platform?.name ?: "" },
            clip = clip,
            userGame = userGame,
            shortScreenshots = shortScreenshots.map { it.mapFromApiToBd() },
            genres = genres.joinToString(",") { it.name ?: "" },
        )
    }
}