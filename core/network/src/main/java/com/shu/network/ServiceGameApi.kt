package  com.shu.network

import com.shu.network.mPlatforms.ResponseGenresDto
import com.shu.network.mPlatforms.ResponsePlatforms
import com.shu.network.model.GameDetailsDto
import com.shu.network.model.ScreenshotsResponse
import com.shu.network.model.base.PagedResponse
import com.shu.network.models2.PagedResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val SIZE = 10

interface ServiceGameApi {

    @GET("/api/games")
    suspend fun gamesPlatforms(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = SIZE,
        @Query("platforms") platforms: String = "18",
    ): PagedResponseDto

    @GET("/api/games")
    suspend fun gamesPopular(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = SIZE,
        @Query("ordering") ordering: String = "name",
    ): PagedResponseDto

    @GET("/api/games")
    suspend fun gamesDate(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = SIZE,
        @Query("ordering") ordering: String = "name",
        @Query("dates") dates: String = "1",
    ): PagedResponseDto

    @GET("/api/games")
    suspend fun gamesGenre(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = SIZE,
        @Query("genres") genres: String = "1",
    ): PagedResponseDto

    @GET("/api/games")
    suspend fun games(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = SIZE,
        @Query("platforms") platforms: String = "1",
    ): PagedResponseDto

    //get ids of target platforms
    @GET("/api/platforms")
    suspend fun platforms(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = SIZE,
        @Query("ordering") ordering: String = "name",
        ): ResponsePlatforms

    @GET("/api/developers")
    suspend fun developers(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = SIZE,
    ): ResponsePlatforms

    @GET("/api/genres")
    suspend fun getGenres(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = SIZE,
    ): ResponseGenresDto

    @GET("/api/games")
    suspend fun gamesAll(
        @Query("page") page: Int = 1,
        @Query("page_size") number: Int = SIZE,
        @Query("search") search: String = "",
        @Query("search_precise") searchPrecise: Boolean = false,
        @Query("search_exact") searchExact: Boolean = false,
        @Query("parent_platforms") parentPlatforms: String = "1",
        @Query("platforms") platforms: String = "1",
        @Query("stores") stores: String = "1",
        @Query("developers") developers: String = "1",
        @Query("publishers") publishers: String = "1",
        @Query("genres") genres: String = "1",
        @Query("tags") tags: String = "1",
        @Query("creators") creators: String = "1",
        @Query("dates") dates: String = "1",
        @Query("updated") updated: String = "1",
        @Query("platformsCount") platformsCount: Int = 1,
        @Query("metacritic") metacritic: String = "80",
        @Query("exclude_collection") excludeCollection: Int = 123,
        @Query("exclude_additions") excludeAdditions: Boolean = false,
        @Query("exclude_parents") excludeParents: Boolean = false,
        @Query("exclude_game_series") excludeGameSeries: Boolean = false,
        @Query("exclude_stores") excludeStores: String = "80",
        @Query("ordering") ordering: String = "name",

        ): PagedResponse

    @GET("/api/games/{id}")
    suspend fun gameDetails(@Path("id") id: Long): GameDetailsDto

    @GET("/api/games/{id}/screenshots")
    suspend fun gameScreenshots(
        @Path("id") id: Long,
        @Query("page_size") number: Int
    ): ScreenshotsResponse


}
