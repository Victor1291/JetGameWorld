package com.shu.network.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.shu.home.domain.HomeRepository
import com.shu.models.ETitle
import com.shu.models.Game
import com.shu.models.QueryParameters
import com.shu.network.ServiceGameApi
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: ServiceGameApi,
    //private val movieDao: MovieDao,
) : HomeRepository {

    override fun getOrdering(params: QueryParameters, title: ETitle): Pager<Int, Game> {
        return  Pager(
            config = PagingConfig(pageSize = 20, initialLoadSize = 20, prefetchDistance = 1),
            pagingSourceFactory = { GamePagingSource(api,title,params) }
        )
    }

    /* suspend fun getAllNewScreen(): ManyScreens {

        return coroutineScope {


            val listGamePlatforms =
                async {
                    getPlatform(
                        params = QueryParameters(
                            page = pageNew.listGamePlatforms,
                            ordering = "added"
                        )
                    ).results.map { it.mapFromApi() }
                }

            val listDevelopers =
                async {
                    getDevelopers(
                        params = QueryParameters(page = pageNew.listDevelopers,)
                    ).results.map { it.mapFromApi() }
                }

            val listPlatforms =
                async {
                    getGamePlatforms(
                        params = QueryParameters(
                            page = pageNew.listPlatforms,
                            platforms = "18" //Playstation 4
                        )
                    ).results.map { it.mapFromApi() }
                }

            val listPopular =
                async { getOrdering(params = QueryParameters(
                    page = pageNew.listPopular,
                    ordering = "added"),title = ETitle.Popular).results.map { it.mapFromApi() } }

            val listRating =
                async { getOrdering(params = QueryParameters(
                    page = pageNew.listRating,
                    ordering = "released"),ETitle.Released).results.map { it.mapFromApi() } }

            val listWaiting =
                async {
                    getDate(
                        params = QueryParameters(
                            page = pageNew.listWaiting,
                            ordering = "added",
                            dates = "2024-10-01,2025-10-01"
                        )
                    ).results.map { it.mapFromApi() }
                }
            val listLastYear =
                async {
                    getDate(
                        params = QueryParameters(
                            page = pageNew.listLastYear,
                            ordering = "added",
                            dates = "2023-10-01,2024-10-01"
                        )
                    ).results.map { it.mapFromApi() }
                }

            return@coroutineScope ManyScreens(
                homeListScreen = listOf(
                    listGamePlatforms.await(),
                    listDevelopers.await(),
                    listPlatforms.await(),
                    listPopular.await(),
                    listRating.await(),
                    listWaiting.await(),
                    listLastYear.await(),
                ),
                listTitle = listTitle.toList(),
            )
        }
    }
*/
   /* private suspend fun getGamePlatforms(params: QueryParameters): PagedResponseDto {
        return api.gamesPlatforms(
            page = params.page,
            pageSize = params.pageSize,
            platforms = params.platforms
        )
    }*/



  /*  private suspend fun getOrdering(params: QueryParameters): PagedResponseDto {
        return api.gamesPopular(
            page = params.page,
            pageSize = params.pageSize,
            ordering = params.ordering
        )
    }*/

   /* private suspend fun getDate(params: QueryParameters): PagedResponseDto {
        return api.gamesDate(
            page = params.page,
            pageSize = params.pageSize,
            ordering = params.ordering,
            dates = params.dates
        )
    }

    private suspend fun getPlatform(params: QueryParameters): ResponsePlatforms {
        return api.platforms(
            page = params.page,
            pageSize = params.pageSize,
            ordering = params.ordering,
        )
    }

    private suspend fun getDevelopers(params: QueryParameters): ResponsePlatforms {
        return api.developers(
            page = params.page,
            pageSize = params.pageSize,
        )
    }*/
}
